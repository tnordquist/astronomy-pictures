package edu.cnm.deepdive.astronomypictures.service;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.astronomypictures.model.dao.UserDao;
import edu.cnm.deepdive.astronomypictures.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class UserRepository {
  private final Application context;
  private final UserDao userDao;

  public UserRepository (Application context) {
    this.context = context;
    userDao = AstronomyDatabase
        .getInstance()
        .getUserDao();
  }

  public LiveData<User> get(long userId) {
    return userDao.select(userId);
  }

  public LiveData<List<User>> getAll() {
    return userDao.selectAll();
  }

  public Single<User> save(User user) {
    Single<User> task;
    if (user.getId() == 0) {
      task = userDao
          .insert(user)
          .map((id) -> {
            user.setId(id);
            return user;
          });
    } else {
      task = userDao
          .update(user)
          .map((count) -> user);
    }
    return task.subscribeOn(Schedulers.io());
  }

  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao
            .delete(user)
            .ignoreElement()
            .subscribeOn(Schedulers.io());
  }
}

package edu.cnm.deepdive.astronomypictures.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import edu.cnm.deepdive.astronomypictures.model.entity.User;
import io.reactivex.Single;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);


}

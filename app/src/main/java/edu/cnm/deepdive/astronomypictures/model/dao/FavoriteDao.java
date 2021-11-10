package edu.cnm.deepdive.astronomypictures.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.astronomypictures.model.entity.Favorite;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface FavoriteDao {

  @Insert
  Single<Long> insert(Favorite favorite);

  @Insert
  Single<List<Long>> insert(Favorite... favorites);

  @Insert
  Single<List<Long>> insert(Collection<Favorite> favorites);

  @Update
  Single<Integer> update(Favorite favorites);

  @Update
  Single<Integer> update(Favorite... favorites);

  @Update
  Single<Integer> update(Collection<Favorite> favorites);

  @Delete
  Single<Integer> delete(Favorite favorite);

  @Delete
  Single<Integer> delete(Favorite... favorites);

  @Delete
  Single<Integer> delete(Collection<Favorite> favorites);

  @Query("SELECT * FROM favorite ORDER BY created DESC")
  LiveData<List<Favorite>> selectAll();

  @Query("SELECT * FROM favorite WHERE favorite_id = :favoriteId")
  LiveData<Favorite> select(long favoriteId);
}
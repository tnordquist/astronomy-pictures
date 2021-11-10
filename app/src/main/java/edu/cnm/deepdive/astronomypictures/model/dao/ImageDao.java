package edu.cnm.deepdive.astronomypictures.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ImageDao {

  @Insert
  Single<Long> insert(Image image);

  @Insert
  Single<List<Long>> insert(Image... images);

  @Insert
  Single<List<Long>> insert(Collection<Image> images);

  @Update
  Single<Integer> update(Image images);

  @Update
  Single<Integer> update(Image... images);

  @Update
  Single<Integer> update(Collection<Image> images);

  @Delete
  Single<Integer> delete(Image image);

  @Delete
  Single<Integer> delete(Image... images);

  @Delete
  Single<Integer> delete(Collection<Image> images);

  @Query("SELECT * FROM image ORDER BY created DESC")
  LiveData<List<Image>> selectAll();

  @Query("SELECT * FROM image WHERE image_id = :imageId")
  LiveData<Image> select(long imageId);
}
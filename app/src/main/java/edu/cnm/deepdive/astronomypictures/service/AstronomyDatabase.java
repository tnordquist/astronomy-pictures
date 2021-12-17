package edu.cnm.deepdive.astronomypictures.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.astronomypictures.model.dao.FavoriteDao;
import edu.cnm.deepdive.astronomypictures.model.dao.ImageDao;
import edu.cnm.deepdive.astronomypictures.model.dao.UserDao;
import edu.cnm.deepdive.astronomypictures.model.entity.Favorite;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import edu.cnm.deepdive.astronomypictures.model.entity.User;
import edu.cnm.deepdive.astronomypictures.service.AstronomyDatabase.Converters;
import java.time.LocalDate;
import java.util.Date;

@Database(
    entities = {User.class, Image.class, Favorite.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class})
public abstract class AstronomyDatabase extends RoomDatabase {

  private static final String DB_NAME = "apod_db";

  private static Application context;

  public static void setContext(Application context) {
    AstronomyDatabase.context = context;
  }

  public static AstronomyDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract ImageDao getImageDao();

  public abstract UserDao getUserDao();

  public abstract FavoriteDao getFavoriteDao();

  private static class InstanceHolder {

    private static final AstronomyDatabase INSTANCE =
        Room.databaseBuilder(context, AstronomyDatabase.class, "astronomy-db")
            .build();

  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }


  }
}
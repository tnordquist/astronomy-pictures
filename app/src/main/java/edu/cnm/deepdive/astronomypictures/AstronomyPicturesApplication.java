package edu.cnm.deepdive.astronomypictures;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.astronomypictures.service.AstronomyDatabase;
import io.reactivex.schedulers.Schedulers;

public class AstronomyPicturesApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Picasso.setSingletonInstance(
        new Picasso.Builder(this)
            .loggingEnabled(BuildConfig.DEBUG)
            .build()
    );
    Stetho.initializeWithDefaults(this);
    AstronomyDatabase.setContext(this);
    AstronomyDatabase
        .getInstance()
        .getImageDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}

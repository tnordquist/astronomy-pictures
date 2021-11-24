package edu.cnm.deepdive.astronomypictures;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.astronomypictures.service.AstronomyDatabase;
import edu.cnm.deepdive.astronomypictures.service.GoogleSignInRepository;
import io.reactivex.schedulers.Schedulers;

public class AstronomyPicturesApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    AstronomyDatabase.setContext(this);
    GoogleSignInRepository.setContext(this);
    AstronomyDatabase
        .getInstance()
        .getImageDao()
        .delete() //act of deleting something forces room to create the database
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}

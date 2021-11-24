package edu.cnm.deepdive.astronomypictures.controller.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AstronomyPicturesViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public AstronomyPicturesViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is home fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}
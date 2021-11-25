package edu.cnm.deepdive.astronomypictures.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AstronomyPicturesViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public AstronomyPicturesViewModel() {
    mText = new MutableLiveData<>();
  }

  public LiveData<String> getText() {
    return mText;
  }
}
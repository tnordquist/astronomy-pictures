package edu.cnm.deepdive.astronomypictures.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import edu.cnm.deepdive.astronomypictures.service.ImageRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class ImageViewModel
    extends AndroidViewModel
    implements LifecycleObserver {


  private final ImageRepository repository;
  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Long> imageId;
  private final LiveData<Image> image;
  private final MutableLiveData<Image> imageLoad;
  private final CompositeDisposable pending;

  public ImageViewModel(@NonNull Application application) {
    super(application);
    repository = new ImageRepository(application);
    throwable = new MutableLiveData<>();
    imageId = new MutableLiveData<>();
    image = Transformations.switchMap(imageId, repository::get);
    pending = new CompositeDisposable();
    imageLoad = new MutableLiveData<>();
    loadImage();
  }

  public LiveData<Image> getImage() {
    return image;
  }

  public LiveData<Image> getImageLoad() {
    return imageLoad;
  }

  public void setImageId(long id) {
    imageId.setValue(id);
  }

  public LiveData<List<Image>> getImages() {
    return repository.getAll();
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void save(Image image) {
    pending.add(
        repository
            .save(image)
            .subscribe(
                (savedImage) -> {
                },
                this::postThrowable
            )
    );
  }

  private void loadImage() {
    pending.add(
        repository.getImage()
            .subscribe(
                imageLoad::postValue,
                throwable::postValue
            )
    );
  }

  public void delete(Image image) {
    pending.add(
        repository
            .delete(image)
            .subscribe(
                () -> {
                },
                this::postThrowable
            )
    );
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }

}

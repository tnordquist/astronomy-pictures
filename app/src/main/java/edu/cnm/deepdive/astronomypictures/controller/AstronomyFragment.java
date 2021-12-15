package edu.cnm.deepdive.astronomypictures.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.astronomypictures.R;
import edu.cnm.deepdive.astronomypictures.adapter.ImageAdapter;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentImageBinding;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import edu.cnm.deepdive.astronomypictures.viewmodel.AstronomyPicturesViewModel;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentAstronomyBinding;
import edu.cnm.deepdive.astronomypictures.viewmodel.ImageViewModel;

public class AstronomyFragment extends Fragment {

  private FragmentAstronomyBinding binding;
  private Image apodImage;
  String apodUrl;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentAstronomyBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    ImageViewModel viewModel = new ViewModelProvider(getActivity()).get(ImageViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel.getApod().observe(getViewLifecycleOwner(), (image) -> {
      Picasso.get().load(image.getUrl()).into(binding.image);
    });
    viewModel.getThrowable().observe(getViewLifecycleOwner(), this::displayError);
  }

  private void displayError(Throwable throwable) {
    if (throwable != null) {
      Snackbar snackbar = Snackbar.make(binding.getRoot(),
          getString(R.string.image_error_message, throwable.getMessage()),
          Snackbar.LENGTH_INDEFINITE);
      snackbar.setAction(R.string.error_dismiss, (v) -> snackbar.dismiss());
      snackbar.show();
    }
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}
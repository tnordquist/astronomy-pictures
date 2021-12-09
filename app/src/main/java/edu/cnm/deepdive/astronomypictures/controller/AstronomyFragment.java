package edu.cnm.deepdive.astronomypictures.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.astronomypictures.viewmodel.AstronomyPicturesViewModel;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentAstronomyBinding;
import edu.cnm.deepdive.astronomypictures.viewmodel.ImageViewModel;

public class AstronomyFragment extends Fragment {

  private ImageViewModel viewModel;
  private FragmentAstronomyBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    viewModel =
        new ViewModelProvider(getActivity()).get(ImageViewModel.class);
    getLifecycle().addObserver(viewModel);
    binding = FragmentAstronomyBinding.inflate(inflater, container, false);
    viewModel.getImageLoad().observe(getViewLifecycleOwner(), (image) ->{
      binding.title.setText(image.getTitle());
    });
    return binding.getRoot();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
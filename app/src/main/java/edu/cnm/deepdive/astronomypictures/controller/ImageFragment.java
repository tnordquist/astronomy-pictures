package edu.cnm.deepdive.astronomypictures.controller;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.astronomypictures.adapter.ImageAdapter;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentImageBinding;
import edu.cnm.deepdive.astronomypictures.viewmodel.ImageViewModel;

public class ImageFragment extends Fragment {

  private FragmentImageBinding binding;
  private ImageViewModel viewModel;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentImageBinding.inflate(inflater, container, false);
//
//    binding.addImages.setOnClickListener((v) -> Navigation
//        findNavController(binding.getRoot())
//        .navigate(ImageFragmentDirections.editImage());
    return binding.getRoot();
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(ImageViewModel.class);
    viewModel
        .getImages()
        .observe(getViewLifecycleOwner(), (images) -> {
          ImageAdapter adapter = new ImageAdapter(getContext(), images);
          binding.images.setAdapter(adapter);
        });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}
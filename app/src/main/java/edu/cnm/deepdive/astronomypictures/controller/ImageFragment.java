//package edu.cnm.deepdive.astronomypictures.controller;
//
//import static androidx.navigation.Navigation.findNavController;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.navigation.Navigation;
//import edu.cnm.deepdive.astronomypictures.adapter.ImageAdapter;
//import edu.cnm.deepdive.astronomypictures.databinding.FragmentImageBinding;
//import edu.cnm.deepdive.astronomypictures.viewmodel.ImageViewModel;
//
//public class ImageFragment extends Fragment {
//
//
//  @Override
//  public View onCreateView(
//      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//  }
//
//  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
//    super.onViewCreated(view, savedInstanceState);
//    viewModel = new ViewModelProvider(this).get(ImageViewModel.class);
//    viewModel
//        .getApod()
//        .observe(getViewLifecycleOwner(), (image) -> {
////          ImageAdapter adapter = new ImageAdapter(getContext(), image);
////          binding.images.setAdapter(adapter);
//        });
//  }
//
//  @Override
//  public void onDestroyView() {
//    super.onDestroyView();
//    binding = null;
//  }
//
//}
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

public class AstronomyFragment extends Fragment {

  private AstronomyPicturesViewModel astronomyPicturesViewModel;
  private FragmentAstronomyBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    astronomyPicturesViewModel =
        new ViewModelProvider(this).get(AstronomyPicturesViewModel.class);

    binding = FragmentAstronomyBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    final TextView textView = binding.textAstronomypictures;
    astronomyPicturesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
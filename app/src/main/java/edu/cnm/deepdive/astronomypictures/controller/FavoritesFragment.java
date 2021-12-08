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
import edu.cnm.deepdive.astronomypictures.viewmodel.FavoriteViewModel;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentFavoritesBinding;

public class FavoritesFragment extends Fragment {

  private FavoriteViewModel favoritesViewModel;
  private FragmentFavoritesBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    favoritesViewModel =
        new ViewModelProvider(this).get(FavoriteViewModel.class);

    binding = FragmentFavoritesBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    final TextView textView = binding.textSlideshow;
    favoritesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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
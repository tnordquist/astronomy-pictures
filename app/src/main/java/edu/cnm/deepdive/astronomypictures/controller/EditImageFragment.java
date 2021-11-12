package edu.cnm.deepdive.astronomypictures.controller;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.astronomypictures.databinding.FragmentEditImageBinding;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import edu.cnm.deepdive.astronomypictures.viewmodel.ImageViewModel;

public class EditImageFragment extends BottomSheetDialogFragment implements TextWatcher {

  private FragmentEditImageBinding binding;
  private ImageViewModel viewModel;
  private long imageId;
  private Image image;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EditImageFragmentArgs args = EditImageFragmentArgs.fromBundle(getArguments());
    imageId = args.getImageId();
  }

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentEditImageBinding.inflate(inflater, container, false);
//    binding.subject.addTextChangedListener(this);
//    binding.text.addTextChangedListener(this);
    binding.cancel.setOnClickListener((v) -> dismiss());
    binding.save.setOnClickListener((v) -> {
//      image.setSubject(binding.subject.getText().toString().trim());
//      image.setText(binding.text.getText().toString().trim());
      viewModel.save(image);
      dismiss();
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(ImageViewModel.class);
    if (imageId != 0) {
    } else {
      image = new Image();
    }
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  @Override
  public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override
  public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override
  public void afterTextChanged(Editable s) {
    checkSubmitConditions();
  }

  private void checkSubmitConditions() {
//    String subject = binding.subject
//        .getText()
//        .toString()
//        .trim();
//    String text = binding.text
//        .getText()
//        .toString()
//        .trim();
//    binding.save.setEnabled(!subject.isEmpty() && !text.isEmpty());
  }
}

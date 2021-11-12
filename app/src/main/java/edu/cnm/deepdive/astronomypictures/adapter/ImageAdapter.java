package edu.cnm.deepdive.astronomypictures.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.astronomypictures.databinding.ItemImageBinding;
import edu.cnm.deepdive.astronomypictures.model.entity.Image;
import java.text.DateFormat;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Holder> {

  private final LayoutInflater inflater;
  private final DateFormat dateFormat;
  private final List<Image> images;

  public ImageAdapter(Context context, List<Image> images) {
    inflater = LayoutInflater.from(context);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    this.images = images;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(ItemImageBinding.inflate(inflater, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return images.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemImageBinding binding;

    private Holder(@NonNull ItemImageBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position) {
      Image note = images.get(position);
//      binding.subject.setText(note.getSubject());
//      binding.updated.setText(dateFormat.format(note.getUpdated()));
//      binding.text.setText(image.getText());
    }
  }
}

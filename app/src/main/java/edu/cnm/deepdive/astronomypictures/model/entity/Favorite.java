package edu.cnm.deepdive.astronomypictures.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    tableName = "favorite",
    foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"user_id"}, childColumns = {
            "user_id"}, onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Image.class, parentColumns = {"image_id"},
            childColumns = {"image_id"}, onDelete = ForeignKey.CASCADE)
    }
)
public class Favorite {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "favorite_id")
  private long id;

  @NonNull
  private Date created = new Date();

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "image_id", index = true)
  private long imageId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }
}

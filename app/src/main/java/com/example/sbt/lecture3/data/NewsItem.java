package com.example.sbt.lecture3.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class NewsItem implements Parcelable {

    private  String title;
    private  String imageUrl;
    private  Category category;
    private  Date publishDate;
    private  String previewText;
    private  String fullText;

    public NewsItem(String title, String imageUrl, Category category, Date publishDate, String previewText, String fullText) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.publishDate = publishDate;
        this.previewText = previewText;
        this.fullText = fullText;
    }


    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getFullText() {
        return fullText;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.imageUrl);
        dest.writeParcelable(this.category, flags);
        dest.writeLong(this.publishDate != null ? this.publishDate.getTime() : -1);
        dest.writeString(this.previewText);
        dest.writeString(this.fullText);
    }

    protected NewsItem(Parcel in) {
        this.title = in.readString();
        this.imageUrl = in.readString();
        this.category = in.readParcelable(Category.class.getClassLoader());
        long tmpPublishDate = in.readLong();
        this.publishDate = tmpPublishDate == -1 ? null : new Date(tmpPublishDate);
        this.previewText = in.readString();
        this.fullText = in.readString();
    }

    public static final Parcelable.Creator<NewsItem> CREATOR = new Parcelable.Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel source) {
            return new NewsItem(source);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };
}




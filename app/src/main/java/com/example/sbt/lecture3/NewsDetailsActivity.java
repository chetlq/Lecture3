package com.example.sbt.lecture3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.sbt.lecture3.data.NewsItem;

public class NewsDetailsActivity extends AppCompatActivity {
    private  RequestManager imageLoader;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ImageView avatarView = (ImageView) findViewById(R.id.avatar1) ;
        TextView title = (TextView) findViewById(R.id.title1);
        TextView date = (TextView) findViewById(R.id.date1);
        TextView fulltext = (TextView) findViewById(R.id.full_text);

        Bundle bundle =  getIntent().getExtras();
        NewsItem news = (NewsItem) bundle.get("key");

        RequestOptions imageOption = new RequestOptions()
                .placeholder(R.drawable.ic_android_black_24dp)
                .fallback(R.drawable.ic_android_black_24dp)
                .centerCrop();
        this.imageLoader = Glide.with(getBaseContext()).applyDefaultRequestOptions(imageOption);
        assert news != null;
        imageLoader.load(news.getImageUrl()).into(avatarView);
        title.setText(news.getTitle());
        date.setText(news.getPublishDate().toString());
        fulltext.setText(news.getFullText());


    }
}

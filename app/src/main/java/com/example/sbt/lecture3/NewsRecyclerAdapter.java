package com.example.sbt.lecture3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.sbt.lecture3.data.NewsItem;

import java.util.Date;
import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    @NonNull
    private final List<NewsItem> news;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;
    @NonNull
    private final RequestManager imageLoader;

    public NewsRecyclerAdapter(@NonNull List<NewsItem> news, @NonNull Context context) {
        this.news = news;
        this.inflater = LayoutInflater.from(context);
        this.context = context;

        RequestOptions imageOption = new RequestOptions()
                .placeholder(R.drawable.ic_android_black_24dp)
                .fallback(R.drawable.ic_android_black_24dp)
                .centerCrop();
        this.imageLoader = Glide.with(context).applyDefaultRequestOptions(imageOption);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.item_actor, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.bind( actors.get(position));
//        holder.nameView.setText(actor.getName());
//        Glide.with(context).load(actor.getAvatar()).into(holder.avatarView);
//        holder.oscarView.setVisibility(actor.isHasOscar()? View.VISIBLE : View.GONE);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView avatarView;
        private final TextView news_category;
        private final TextView title;
        private final TextView preview_text;
        private final TextView date;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.avatar);
            news_category = itemView.findViewById(R.id.news_category);
            title = itemView.findViewById(R.id.title);
            preview_text = itemView.findViewById(R.id.preview_text);
            date = itemView.findViewById(R.id.date);
        }

        void bind(NewsItem news) {
            imageLoader.load(news.getImageUrl()).into(avatarView);
            news_category.setText(news.getCategory().getName());
            title.setText(news.getTitle());
            preview_text.setText(news.getPreviewText());
            date.setText(String.valueOf(news.getPublishDate()) );

        }
    }

//    public void replaceData(List<Actor> newActor){
//        DiffUtil.DiffResult diff = DiffUtil.calculateDiff(
//                new DiffUtil.Callback() {
//                    @Override
//                    public int getOldListSize() {
//                        return 0;
//                    }
//
//                    @Override
//                    public int getNewListSize() {
//                        return 0;
//                    }
//
//                    @Override
//                    public boolean areItemsTheSame(int i, int i1) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean areContentsTheSame(int i, int i1) {
//                        return false;
//                    }
//                }
//        )
//    }

}

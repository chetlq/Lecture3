package com.example.sbt.lecture3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ActorRecyclerAdapter extends RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder> {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;
    @NonNull
    private final RequestManager imageLoader;

    public ActorRecyclerAdapter(@NonNull List<Actor> actors,  @NonNull Context context) {
        this.actors = actors;
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
        private final TextView nameView;
        private final ImageView oscarView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.avatar);
            nameView = itemView.findViewById(R.id.name);
            oscarView = itemView.findViewById(R.id.oscar);
        }

        void bind(Actor actor) {
            imageLoader.load(actor.getAvatar()).into(avatarView);
            nameView.setText(actor.getName());
            oscarView.setVisibility(actor.isHasOscar() ? View.VISIBLE : View.GONE);
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

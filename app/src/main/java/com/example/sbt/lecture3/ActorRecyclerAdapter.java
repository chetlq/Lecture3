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

import java.util.List;

public class ActorRecyclerAdapter extends RecyclerView.Adapter<ActorRecyclerAdapter.ViewHolder> {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;

    public ActorRecyclerAdapter(@NonNull List<Actor> actors,  @NonNull Context context) {
        this.actors = actors;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.item_actor, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);
        holder.nameView.setText(actor.getName());
        Glide.with(context).load(actor.getAvatar()).into(holder.avatarView);
        holder.oscarView.setVisibility(actor.isHasOscar()? View.VISIBLE : View.GONE);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatarView;
        final TextView nameView;
        final ImageView oscarView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarView = itemView.findViewById(R.id.avatar);
            nameView = itemView.findViewById(R.id.name);
            oscarView = itemView.findViewById(R.id.oscar);
        }
    }

}

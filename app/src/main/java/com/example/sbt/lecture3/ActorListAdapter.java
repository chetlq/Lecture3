package com.example.sbt.lecture3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

public class ActorListAdapter extends BaseAdapter {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;

    public ActorListAdapter(@NonNull List<Actor> actors,  @NonNull Context context) {
        this.actors = actors;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }


    @Override
    public int getCount() {
        return actors.size();
    }

    @Override
    public Object getItem(int i) {
        return actors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowItem = inflater.inflate(R.layout.item_actor,viewGroup,false);
        ImageView avatarView = rowItem.findViewById(R.id.avatar);
        TextView nameView = rowItem.findViewById(R.id.name);
        ImageView oscarView = rowItem.findViewById(R.id.oscar);

        Actor actor = actors.get(i);
        nameView.setText(actor.getName());
        Glide.with(context).load(actor.getAvatar()).into(avatarView);
        if (actor.isHasOscar()){
            oscarView.setVisibility(View.VISIBLE);
        }


        return rowItem;
    }
}

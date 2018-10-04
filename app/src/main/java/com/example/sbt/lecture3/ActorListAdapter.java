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
    public View getView(int i,@NonNull View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = onCreateViewHolder(parent);
            convertView = holder.itemView;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        onBindViewHolder(holder, i);
        return convertView;
    }



    private void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Actor actor = actors.get(position);
        holder.nameView.setText(actor.getName());
        Glide.with(context).load(actor.getAvatar()).into(holder.avatarView);
        holder.oscarView.setVisibility(actor.isHasOscar()? View.VISIBLE : View.GONE);
    }
    private ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_actor, parent, false));
    }

    static class ViewHolder {
        final View itemView;

        final ImageView avatarView;
        final TextView nameView;
        final ImageView oscarView;

        ViewHolder(@NonNull View itemView) {
            this.itemView = itemView;
            this.avatarView = itemView.findViewById(R.id.avatar);
            this.nameView = itemView.findViewById(R.id.name);
            this.oscarView = itemView.findViewById(R.id.oscar);
        }
    }

}

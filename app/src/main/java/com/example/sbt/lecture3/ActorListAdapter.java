package com.example.sbt.lecture3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.List;
import java.util.Objects;

public class ActorListAdapter extends BaseAdapter {
    @NonNull
    private final List<Actor> actors;
    @NonNull
    private final LayoutInflater inflater;
    @NonNull
    private final Context context;

    public ActorListAdapter(@NonNull List<Actor> actors, @NonNull LayoutInflater inflater, @NonNull Context context) {
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
        return null;
    }
}

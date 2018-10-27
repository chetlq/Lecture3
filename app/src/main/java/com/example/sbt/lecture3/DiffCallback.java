package com.example.sbt.lecture3;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class DiffCallback extends DiffUtil.Callback {
    private final List<Actor> oldItem;
    private final List<Actor> newItem;

    public DiffCallback(List<Actor> oldItem, List<Actor> newItem) {
        this.oldItem = oldItem;
        this.newItem = newItem;
    }

    @Override
    public int getOldListSize() {
        return oldItem.size();
    }

    @Override
    public int getNewListSize() {
        return newItem.size();
    }

    @Override
    public boolean areItemsTheSame(int i, int i1) {
        return oldItem.get(i).getName().equals(newItem.get(i1).getName());
    }

    @Override
    public boolean areContentsTheSame(int i, int i1) {
        return oldItem.get(i).getName().equals(newItem.get(i1).getName());
    }
}

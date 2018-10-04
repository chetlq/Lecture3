package com.example.sbt.lecture3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActorListAdapter adapter;
    private  Actor actor;
    private final AdapterView.OnItemClickListener clickListener = (adapterView, view, position, id) -> {
        actor =(Actor) adapter.getItem(position);
        String clickMessage = DataUtils.getActorMessage(this, actor);

        Toast.makeText(this, clickMessage, Toast.LENGTH_SHORT).show();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_recycler);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(new ActorRecyclerAdapter(DataUtils.generateActors(), this));

//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(new ActorListAdapter(DataUtils.generateActors(),this));
//        listView.setOnItemClickListener(clickListener);
    }
}
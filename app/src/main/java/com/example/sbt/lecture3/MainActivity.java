package com.example.sbt.lecture3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.sbt.lecture3.data.DataUtils;

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
        recyclerView.setAdapter(new NewsRecyclerAdapter(DataUtils.generateActors(), this));

//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(new ActorListAdapter(DataUtils.generateActors(),this));
//        listView.setOnItemClickListener(clickListener);
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_switch:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
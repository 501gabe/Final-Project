package com.gabe.android.aca.snoozecamp;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import static com.gabe.android.aca.snoozecamp.R.id.recyclerView;

/**
 * Created by Gabe on 11/4/16.
 */

public class LookbookActivity extends MainActivity {
    RecyclerView mRecyclerView;
    LookbookAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lookbook);


        mRecyclerView = (RecyclerView) findViewById(recyclerView);


        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        mAdapter = new LookbookAdapter(this);////////ADAPTER
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<Lookbook> lookbooks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            lookbooks.add(new Lookbook());
        }

        mAdapter.setLookbookList(lookbooks);




    }


}




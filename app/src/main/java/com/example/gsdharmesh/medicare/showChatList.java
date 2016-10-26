package com.example.gsdharmesh.medicare;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class showChatList extends AppCompatActivity {
    private List<doctors> docList = new ArrayList<>();
    private RecyclerView recyclerView;
    private docAdapter dAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chat_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);

        dAdapter = new docAdapter(docList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        prepareDocData();


    }

    private void prepareDocData() {
        doctors doc1 = new doctors("Dr.Prashant Kumar Gupta", "B.Tech IT", "Online");
        docList.add(doc1);
        doctors doc2 = new doctors("Dr.S.Madhu Soodhan", "B.Tech IT", "Online");
        docList.add(doc2);
        dAdapter.notifyDataSetChanged();
    }

    private void refreshContent() {
        //Write the code for refresh here

        mSwipeRefreshLayout.setRefreshing(false);
    }
}

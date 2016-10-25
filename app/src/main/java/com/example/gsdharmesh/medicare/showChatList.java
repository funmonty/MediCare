package com.example.gsdharmesh.medicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class showChatList extends AppCompatActivity {
    private List<doctors> docList = new ArrayList<>();
    private RecyclerView recyclerView;
    private docAdapter dAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chat_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        dAdapter = new docAdapter(docList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dAdapter);

        prepareDocData();


    }
    private void prepareDocData() {
        doctors doc1 = new doctors("Dr.Prashant Kumar Gupta", "B.Tech IT", "Online");
        docList.add(doc1);
        doctors doc2 = new doctors("Dr.S.Madhu Soodhan", "B.Tech IT", "Online");
        docList.add(doc2);
        dAdapter.notifyDataSetChanged();
    }
}

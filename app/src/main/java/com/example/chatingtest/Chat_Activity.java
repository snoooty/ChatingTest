package com.example.chatingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Chat_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private chatingAdapter adapter;

    private ArrayList<user_chat_item> chatActivityDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerView = findViewById(R.id.chat_recyclerview);

        adapter = new chatingAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        chatActivityDataList = new ArrayList<>();

        chatActivityDataList.add(new user_chat_item("nooty","안녕"));

        adapter.setAdapterChatList(chatActivityDataList);

    }
}
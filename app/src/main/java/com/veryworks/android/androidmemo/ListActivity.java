package com.veryworks.android.androidmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        initListener();
        init();
    }

    private void init(){
        File list[] = loadData();
        ListAdapter adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private File[] loadData(){
        return getFilesDir().listFiles();
    }

    private void initListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        btnPost = (Button) findViewById(R.id.btnPost);
    }
}

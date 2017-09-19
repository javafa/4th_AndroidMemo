package com.veryworks.android.androidmemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WriteActivity extends AppCompatActivity {

    private Button btnPost;
    private EditText editTitle;
    private EditText editAuthor;
    private EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        initView();
        initListener();
    }

    private void write(){
        // 내용을 등록하고, 목록으로 이동

        // 현재 액티비티를 종료한다.
        finish();
    }

    private void initListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                write();
            }
        });
    }

    private void initView() {
        btnPost = (Button) findViewById(R.id.btnPost);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editAuthor = (EditText) findViewById(R.id.editAuthor);
        editContent = (EditText) findViewById(R.id.editContent);
    }
}

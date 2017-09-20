package com.veryworks.android.androidmemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.veryworks.android.androidmemo.domain.Memo;

import java.io.File;
import java.io.FileOutputStream;

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

    /**
     * 내용을 파일에 작성
     * - 파일쓰기
     *   내부저장소 - Internal : 개별앱만 접근가능, 파일탐색기에서 보이지 않는다.
     *   외부저장소 - External : 모든앱이 접근가능 > 권한 필요
     */
    private static final String DIR_INTR = "/data/data/com.veryworks.android.androidmemo/files/";

    private Memo getMemoFromScreen(){
        Memo memo = new Memo();
        memo.setNo(1);
        memo.setTitle(editTitle.getText().toString());
        memo.setAuthor(editAuthor.getText().toString());
        memo.setContent(editContent.getText().toString());
        memo.setDatetime(System.currentTimeMillis());
        return memo;
    }
    private void write(Memo memo){
        try {
            String filename = System.currentTimeMillis() + ".txt";
            File file = new File(DIR_INTR + filename);
            // 1. 스트림을 열고
            FileOutputStream fos = new FileOutputStream(file);
            // 2. 내용을 쓴다.
            fos.write(memo.toBytes());
        }catch(Exception e){
            Toast.makeText(this, "에러:"+e.toString(), Toast.LENGTH_SHORT).show();
        }
        finish();
    }
    private void initListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Memo memo = getMemoFromScreen();
                write(memo);
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

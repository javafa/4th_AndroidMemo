package com.veryworks.android.androidmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.veryworks.android.androidmemo.domain.Memo;

import java.io.File;
import java.util.ArrayList;

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

    // 목록을 초기화
    private void init(){
        Log.d("ListActivity","called init()");
        ArrayList<Memo> list = loadData();
        ListAdapter adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private ArrayList<Memo> loadData(){
        ArrayList<Memo> result = new ArrayList<>();
        // 파일목록에서 파일을 하나씩 꺼낸후에
        // Memo 클래스로 변환한후 result 에 담는다
        for(File item : getFilesDir().listFiles()){
            Memo memo = new Memo();

            String text = item... 읽어와야된다.;


            result.add(memo);
        }

        return result;
    }

    private static final int WRITE_ACITIVTY = 12345;

    private void initListener() {
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, WriteActivity.class);
                startActivityForResult(intent, WRITE_ACITIVTY);
               // startActivity(intent);
            }
        });
    }

    // startActivityForResult 를 통해 호출된 액티비티가 종료되는 순간 호출되는 함수
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case WRITE_ACITIVTY:
                if(resultCode == RESULT_OK) {
                    init();
                }
                break;
        }
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        btnPost = (Button) findViewById(R.id.btnPost);
    }
}

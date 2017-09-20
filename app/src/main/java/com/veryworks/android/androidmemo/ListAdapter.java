package com.veryworks.android.androidmemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by pc on 9/20/2017.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    // 1. 저장소
    File[] data;
    // 2. 생성자 정의
    public ListAdapter(Context context, File[] data){
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if(view == null){ // 뷰가 최초 생성될경우
            // 1. 뷰 생성
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item_list, null);
            // 2. 홀더생성
            holder = new Holder(view);
            // 3. 뷰에 홀더를 붙인다
            view.setTag(holder);
        }else{ // 뷰가 두번째 호출되면 (즉 한화면이 넘어가면)
            // 1. 뷰에 붙인 홀더를 꺼낸다
            holder = (Holder) view.getTag();
        }
        // 값을 세팅
        // 1. 컬렉션 구조의 저장소로부터 객체 단위로 꺼내두는게 사용하기 편하다.
        File memo = data[position];
        // 2. 홀더의 위젯에 데이터를 입력한다
        //holder.setNo(memo.getNo());
        //holder.setTitle(memo.getTitle());
        //holder.setDate(memo.getDatetime());
        holder.setTitle(memo.getName());
        return view;
    }
}

class Holder {
    private TextView textNo;
    private TextView textTitle;
    private TextView textDate;
    public Holder(View view){
        textNo = view.findViewById(R.id.textNo);
        textTitle = view.findViewById(R.id.textTitle);
        textDate = view.findViewById(R.id.textDate);
    }
    public void setNo(int no) {
        textNo.setText(no + "");
    }
    public void setTitle(String title) {
        textTitle.setText(title);
    }
    public void setDate(Long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String result = sdf.format(datetime);
        textDate.setText(result);
    }
}

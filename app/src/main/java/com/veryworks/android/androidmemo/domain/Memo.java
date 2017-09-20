package com.veryworks.android.androidmemo.domain;

/**
 * Created by pc on 9/19/2017.
 */

public class Memo {
    private int no;
    private String title;
    private String author;
    private String content;
    private long datetime;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("no:^:").append(no).append("\n");
        result.append("title:^:").append(title).append("\n");
        result.append("author:^:").append(author).append("\n");
        result.append("datetime:^:").append(datetime).append("\n");
        result.append("content:^:").append(content).append("\n");
        return result.toString();
    }

    public byte[] toBytes(){
        return toString().getBytes(); // 문자열에서 바이트배열로 변환
    }
}

/*
글번호 :^: 1
제목 :^: 제목입니다
작성자 :^: 홍길도
작성일자 :^: 2017/09/20 10:55
내용 :^: 라ㅣㅓㅣㅏㅁㅇㄹ
ㅇ미라ㅓㄴㅇㅁㄹ
ㅏㅇ럼니
이ㅏ러ㅣ
ㅣㅓㄹㄴㅁ
 */

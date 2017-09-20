package com.veryworks.android.androidmemo.util;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by pc on 9/20/2017.
 */

public class FileUtil {
    /**
     * 파일 쓰기 함수
     * @param context 컨텍스트
     * @param filename 파일이름
     * @param content 내용
     * @throws IOException
     */
    public static void write(Context context,String filename, String content)
            throws IOException {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(filename, MODE_PRIVATE);
            fos.write(content.getBytes());
        }catch(Exception e){
            throw e;
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

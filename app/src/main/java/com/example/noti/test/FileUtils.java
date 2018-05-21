package com.example.noti.test;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileUtils {
    /**
     * data 字符串数据
     * context 上下文对象
     * fileName 文件名称
     */
    public void savaData(String data, Context context, String fileName) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName + ".txt", Context.MODE_PRIVATE);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            fileOutputStream.write(data.getBytes());
            if (fileOutputStream != null) {
                writer.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取数据
     * name表示文件名称
     * context上下文对象
     */
    public String findData(String fileName, Context context) {
        File cacheDir = context.getFilesDir();
        ;
        File file = new File(cacheDir, fileName + ".txt");
        if (file.exists()) {
            try {
                FileInputStream inputStream = context.openFileInput(fileName + ".txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String str = null;
                StringBuffer stringBuffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    stringBuffer.append(str);
                }
                return stringBuffer.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
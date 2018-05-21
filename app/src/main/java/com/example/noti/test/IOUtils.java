package com.example.noti.test;

import android.content.Context;
import android.util.Log;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Auther: Scott
 * Date: 2017/1/6 0006
 * E-mail:hekescott@qq.com
 */

public class IOUtils {
    public static <T> void writeObject(Context context, T t, String name) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(name, Context.MODE_PRIVATE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(t);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
        } finally {
            close(objectOutputStream);
            close(fileOutputStream);
        }

    }
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e("tag",e.getLocalizedMessage());
            }
        }
    }
    public synchronized static <T> T getObject(Context context, String fileName) {
        T t1 = null;
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            t1 = (T) objectInputStream.readObject();

        } catch (Exception e) {
            Log.e("IOUtils【反序列化对象失败:】", e.getMessage());
        } finally {
            close(fileInputStream);
            close(objectInputStream);
        }
        return t1;
    }

}

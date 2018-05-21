package com.example.noti.test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 10264 on 2018/4/19.
 */

public class TestModel implements Serializable {
    public String name;
    public int age;
    public List<Test2Model> data;

    public TestModel() {
    }
}

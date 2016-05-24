package com.example.lpjxlove.labelview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LabelView labelView;
    private Label_ViewAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelView = (LabelView) findViewById(R.id.label_view);
        list = new ArrayList<>();
        list.add("我喜欢你,你好呀");
        list.add("来日方长");
        list.add("我的爱人");
        list.add("方长");
        list.add("我的爱人");
        list.add("广东工业大学");
        list.add("哈哈");
        adapter = new Label_ViewAdapter(this, list);
        labelView.setAdapter(adapter);
    }
}

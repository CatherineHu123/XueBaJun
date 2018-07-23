package com.example.gloria.myapplication;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String path;// 字体存放路径
    TextView title;// 学吧君的标题文字
    TextView search;
    Spinner spinner;
    List<String> data_list;
    ArrayAdapter<String> arr_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        path = "font" + File.separator + "xinwei.TTF";
        AssetManager manager = this.getAssets();
        Typeface font = Typeface.createFromAsset(manager , path);
        title.setTypeface(font);

        spinner = (Spinner) findViewById(R.id.spinner);

        //数据
        data_list = new ArrayList<String>();
        data_list.add("课程");
        data_list.add("书籍");
        data_list.add("资料");

        //适配器
        arr_adapter= new ArrayAdapter<String>(this, R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);

        // 监听
        search = (TextView) findViewById(R.id.search) ;
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {//选择item的选择点击监听事件
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                // 将所选mySpinner 的值带入myTextView 中
                search.setText( data_list.get(arg2) );//文本说明
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                search.setText("Nothing");
            }
        });
    }


}

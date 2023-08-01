package com.yvan.hookams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * @author yvan
 * @date 2023/7/28
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳转到列表页面
     *
     * @param view
     */
    public void toListPage(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

}
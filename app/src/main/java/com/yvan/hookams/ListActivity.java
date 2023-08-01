package com.yvan.hookams;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author yvan
 * @date 2023/7/28
 * @description
 */
public class ListActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    /**
     * 退出登录
     *
     * @param view
     */
    public void logout(View view) {
        SharedPreferences share = this.getSharedPreferences(Config.SP_NAME, MODE_PRIVATE);
        // 使处于可编辑状态
        SharedPreferences.Editor editor = share.edit();
        // 设置保存的数据
        editor.putBoolean(Config.SP_KEY_LOGIN, false);
        Toast.makeText(this, "退出登录成功", Toast.LENGTH_SHORT).show();
        // 提交数据保存
        editor.commit();
        finish();
    }
}

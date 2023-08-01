package com.yvan.hookams;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * @author yvan
 * @date 2023/7/28
 * @description
 */
public class LoginActivity extends Activity {

    EditText name;
    EditText password;
    private String className;
    SharedPreferences share;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        share = this.getSharedPreferences(Config.SP_NAME, MODE_PRIVATE);//实例化
        className = getIntent().getStringExtra("extraIntent");
        if (className != null) {
            ((TextView) findViewById(R.id.text)).setText(" 跳转界面：" + className);
        }
    }

    /**
     * 点击登录
     *
     * @param view
     */
    public void loginClick(View view) {
        if ((name.getText() == null || password.getText() == null)) {
            Toast.makeText(this, "请填写用户名或密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Config.LOGIN_NAME.equals(name.getText().toString()) && Config.LOGIN_PASSWORD.equals(password.getText()
                .toString())) {
            //实例化
            SharedPreferences share = super.getSharedPreferences(Config.SP_NAME, MODE_PRIVATE);
            //使处于可编辑状态
            SharedPreferences.Editor editor = share.edit();
            editor.putString(Config.SP_KEY_NAME, name.getText().toString());
            editor.putString(Config.SP_KEY_PASSWORD, password.getText().toString());
            //设置保存的数据
            editor.putBoolean(Config.SP_KEY_LOGIN, true);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            //提交数据保存
            editor.commit();
            if (className != null) {
                ComponentName componentName = new ComponentName(this, className);
                Intent intent = new Intent();
                intent.setComponent(componentName);
                startActivity(intent);
            }
            finish();
        } else {
            //使处于可编辑状态
            SharedPreferences.Editor editor = share.edit();
            //设置保存的数据
            editor.putBoolean(Config.SP_KEY_LOGIN, false);
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
            //提交数据保存
            editor.commit();
        }
    }
}

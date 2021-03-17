package com.example.test1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test1.util.ToastUtil;

public class MainActivity extends AppCompatActivity{
    //声明控件
    private Button MaButton;
    private EditText musername;
    private EditText mpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //找到控件
        MaButton = findViewById(R.id.login);
        musername = findViewById(R.id.user);
        mpass = findViewById(R.id.password);

//                //实现跳转
//        MaButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =null;
//                intent = new Intent(MainActivity.this,FunctionActivity.class);
//                startActivity(intent);
//
//            }
//        });
        //匹配对应的用户名才可进行跳转
        MaButton.setOnClickListener(this::onClick);

    }



        private void onClick(View v) {
        //获取输入
            String username = musername.getText().toString();
            String password = mpass.getText().toString();

            //弹出的内容
            String ok = "登录成功！！";
            String fail = "密码或账号有误，请重试";
            Intent intent = null;

         //正确账号密码为wdnmd，123456
            if (username.equals("wdnmd") && password.equals("123456")) {

//                //toast easy
//                Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

        //封装好的类
               ToastUtil.showMsg(MainActivity.this,ok);
        //跳转
       //如果正确的话进行跳转
                intent = new Intent(MainActivity.this,FunctionActivity.class);
                startActivity(intent);
            } else {
         //不正确的话，显示密码错误 toast hard
                Toast toastCenter = Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_LONG);
                toastCenter.setGravity(Gravity.CENTER,0,0);
                toastCenter.show();

            }
            }
        }




package com.example.mvvm;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvvm.bean.User;
import com.example.mvvm.bean.UserEvent;
import com.example.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog mDialog;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUser = new User();

        mUser.userName = "john";
        binding.setUser(mUser);
        binding.setEvent(new UserEvent(mUser));

        mDialog = new ProgressDialog(this);

    }

    public void login(View view) {
        if (checkUser(mUser)) {
            mDialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    Log.d("aaa", "run: " + mUser.userName);
                    if ("john".equals(mUser.userName) && "456".equals(mUser.passWord)) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mDialog.dismiss();
                                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mDialog.dismiss();
                                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }).start();
        } else {
            Toast.makeText(MainActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkUser(User user) {
        return !(TextUtils.isEmpty(mUser.userName) && TextUtils.isEmpty(mUser.passWord));
    }
}

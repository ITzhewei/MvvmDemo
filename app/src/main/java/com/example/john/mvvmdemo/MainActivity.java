package com.example.john.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.john.mvvmdemo.bean.User;
import com.example.john.mvvmdemo.bean.UserEvent;
import com.example.john.mvvmdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User mUser;
    public EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mUser = new User();
        //        mUser.userName.set("john");
        mUser.userName = "john";
        binding.setUser(mUser);
        binding.setEvent(new UserEvent(mUser));


        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                SystemClock.sleep(2000);
        //                //                mUser.userName.set("这时我发生改变了啊");
        //                //通知(notify)发生了改变
        //
        //            }
        //        }).start();
    }

    public void test(View view) {
        Toast.makeText(MainActivity.this, "name:" + mUser.userName, Toast.LENGTH_SHORT).show();
    }
}

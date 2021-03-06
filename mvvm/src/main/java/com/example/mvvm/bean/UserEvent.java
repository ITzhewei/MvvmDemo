package com.example.mvvm.bean;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by ZheWei on 2016/9/7.
 */
public class UserEvent {

    public User mUser;

    public UserEvent(User user) {
        mUser = user;
    }


    public TextWatcher userNameWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mUser.userName = s.toString();
        }
    };

    public TextWatcher passWordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mUser.passWord = s.toString();
        }
    };
}

package com.health.medicationtracker.ui.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.health.medicationtracker.ui.main.MainActivity;

public class LoginHandler {
    private final Context context;

    public LoginHandler(Context context) {
        this.context = context;
    }

    public void loginHandler(View view){
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);
    }
}

package com.example.interfaceproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void nono(View view) {

        FunctionManager.getInstance().invokeFunction("nono");

    }


    public void hashas(View view) {
        String hashas = FunctionManager.getInstance().invokeFunction("hashas", 11, String.class);
        Log.e("hashas: ", hashas);

    }

    public void hasno(View view) {
        FunctionManager.getInstance().invokeFunction("hasno", "params");

    }

    public void nohas(View view) {
        String nohas = FunctionManager.getInstance().invokeFunction("nohas", String.class);
        Log.e("nohas: ", nohas);

    }
}

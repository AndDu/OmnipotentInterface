package com.example.interfaceproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FunctionManager.getInstance().addFunction(new FunctionNoParamsNoResult("nono") {
            @Override
            public void function() {
                Log.e("function: ", "nono");
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionNoParamsHasResult<String>("nohas") {
            @Override
            public String function() {
                return "nohas";
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamsNoResult<String>("hasno") {
            @Override
            public void function(String params) {
                Log.e("hasno: ", params);
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionHasParamsHasResult<String, Integer>("hashas") {
            @Override
            public String function(Integer params) {
                Log.e("hashas: ", params + "");
                return "hashas";
            }
        });
    }

    public void onClick(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);


    }
}

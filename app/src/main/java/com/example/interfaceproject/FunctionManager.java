package com.example.interfaceproject;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class FunctionManager {


    private Map<String, FunctionNoParamsNoResult> mNoParamsNoResultMap;
    private Map<String, FunctionHasParamsHasResult> mHasParamsHasResultMap;
    private Map<String, FunctionNoParamsHasResult> mNoParamsHasResultMap;
    private Map<String, FunctionHasParamsNoResult> mHasParamsNoResultMap;


    private static FunctionManager instance;

    private FunctionManager() {
        mNoParamsNoResultMap = new HashMap<>();
        mHasParamsHasResultMap = new HashMap<>();
        mNoParamsHasResultMap = new HashMap<>();
        mHasParamsNoResultMap = new HashMap<>();
    }


    public static FunctionManager getInstance() {

        if (instance == null) {
            instance = new FunctionManager();
        }

        return instance;
    }


    //添加没有参数没有返回值的方法
    public void addFunction(FunctionNoParamsNoResult function) {

        mNoParamsNoResultMap.put(function.functionName, function);

    }

    //执行没有参数没有返回值的方法
    public void invokeFunction(String functionName) {
        if (!TextUtil.isEmpty(functionName)) {
            return;
        }


        if (mNoParamsNoResultMap != null) {
            FunctionNoParamsNoResult f = mNoParamsNoResultMap.get(functionName);
            if (f != null) {
                f.function();
            } else {
                Log.e("invokeFunction: ", "没有找到该方法");
            }
        }

    }


    //添加没有参数有返回值的方法
    public void addFunction(FunctionNoParamsHasResult function) {

        mNoParamsHasResultMap.put(function.functionName, function);

    }


    public <T> T invokeFunction(String functionName, Class<T> t) {
        if (!TextUtil.isEmpty(functionName)) {
            return null;
        }

        if (mNoParamsHasResultMap != null) {
            FunctionNoParamsHasResult f = mNoParamsHasResultMap.get(functionName);
            if (f != null) {
                if (t != null) {
                    return t.cast(f.function());
                }
            }
        } else {
            Log.e("invokeFunction: ", "没有找到该方法");
        }

        return null;
    }


    //添加有参数没有返回值的方法
    public void addFunction(FunctionHasParamsNoResult function) {
        mHasParamsNoResultMap.put(function.functionName, function);

    }


    public <P> void invokeFunction(String functionName, P p) {

        if (!TextUtil.isEmpty(functionName)) {
            return;
        }

        if (mHasParamsNoResultMap != null) {
            FunctionHasParamsNoResult f = mHasParamsNoResultMap.get(functionName);

            if (f != null) {
                f.function(p);
            } else {
                Log.e("invokeFunction: ", "没有找到该方法");
            }

        }

    }


    //添加有参数有返回值的方法
    public void addFunction(FunctionHasParamsHasResult function) {

        mHasParamsHasResultMap.put(function.functionName, function);


    }


    public <T, P> T invokeFunction(String functionName, P p, Class<T> t) {
        if (!TextUtil.isEmpty(functionName)) {
            return null;
        }

        if (mHasParamsHasResultMap != null) {
            FunctionHasParamsHasResult f = mHasParamsHasResultMap.get(functionName);
            if (f != null) {
                if (t != null) {
                    return t.cast(f.function(p));
                }
            }
        }

        return null;
    }

}

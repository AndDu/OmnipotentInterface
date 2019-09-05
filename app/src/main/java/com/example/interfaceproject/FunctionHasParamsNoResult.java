package com.example.interfaceproject;

public abstract class FunctionHasParamsNoResult<P> extends Function {


    public FunctionHasParamsNoResult(String functionName) {
        super(functionName);
    }


    public abstract void function(P params);

}

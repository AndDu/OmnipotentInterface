package com.example.interfaceproject;

public abstract class FunctionNoParamsHasResult<R> extends Function {


    public FunctionNoParamsHasResult(String functionName) {
        super(functionName);
    }

    public abstract R  function();
}

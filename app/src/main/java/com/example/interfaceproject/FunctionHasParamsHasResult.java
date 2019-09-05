package com.example.interfaceproject;

public abstract class FunctionHasParamsHasResult<R,P> extends Function {



    public FunctionHasParamsHasResult(String functionName) {
        super(functionName);
    }


    public abstract R function(P params);

}

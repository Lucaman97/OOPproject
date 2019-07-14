package com.esame.progetto.service;
import java.lang.reflect.Method;

public class InvokesMethod implements InvokesMethodItf
{

private Method method;

@Override
public Object invokeMethod() throws Exception {
     return method.invoke(null);
}

@Override
public void setMethod(Method method) {
    this.method = method;
}

}
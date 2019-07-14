package com.esame.progetto.service;
import java.lang.reflect.Method;
import java.util.*;

import com.esame.progetto.model.Record;

public class Terminal {

public HashMap<String, InvokesMethodItf> commands;
public Terminal(Record r) {
    this.commands = new HashMap<String, InvokesMethodItf>();
    try {
        this.setCommand("pp",
             this.getClass().getDeclaredMethod("getAnno2000"), r);
        /*
        this.setCommand("popo",
                this.getClass().getDeclaredMethod("getAnno2001"));
        
        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2002"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2003"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2004"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2005"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2006"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2007"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2008"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2009"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2010"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2011"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2012"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2013"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2014"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2015"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2016"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getAnno2017"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getFREQ"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getGEO"));

        this.setCommand("pp",
                this.getClass().getDeclaredMethod("getOBJ"));
        */
           
           

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void setCommand(String field, Method method, Record r) {

    InvokesMethodItf inv = new InvokesMethod();

    inv.setMethod(method);

    this.commands.put(field, inv);
}

public Object executeCommand(String field) throws Exception {
    return this.commands.get(field).invokeMethod();
 }







public static Object getAnno2000(Record r) {// method.invoke(null) looking for "static" method
    System.out.println("Hello World!");
    return r.getAnno2000();
}
}





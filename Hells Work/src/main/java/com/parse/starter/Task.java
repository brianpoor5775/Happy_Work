package com.parse.starter;

/**
 * Created by Jean Leong on 5/13/2016.
 */
public class Task {
    String name, date, subject;
    public Task(String id, String date, String subject){
        name = id;
        this.date = date;
        this.subject = subject;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){this.subject = subject;}
    public void setName(String name){this.name = name;}
    public void setDate(String date){this.date = date;}
}

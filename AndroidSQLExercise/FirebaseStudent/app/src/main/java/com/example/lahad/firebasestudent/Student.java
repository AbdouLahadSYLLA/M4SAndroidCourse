package com.example.lahad.firebasestudent;

/**
 * Created by lahad on 31/07/2016.
 */
public class Student {

    private String id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String firstname;

    public Student(){
        this.id="0";
        this.firstname="lahad";
    }

    public Student(String id, String firtsname){
        this.id=id;
        this.firstname=firtsname;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

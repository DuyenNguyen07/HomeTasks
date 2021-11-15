package com.DuyenNguyen.experimenting.reqres.models;

import org.openqa.selenium.json.Json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;    // https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/annotation/XmlRootElement.html

public class User {
    private int id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String avatar;
    private String job;
    private String url;
    private String text;
    private Json data;
    private Json support;

    public User() {
    }

    // Used for POST requests - Create user
    public User(String email, String first_name, String last_name, String avatar) {
        setEmail(email);
        setFirst_name(first_name);
        setLast_name(last_name);
        setAvatar(avatar);
    }

    // Used for PUT requests - Update user
    public User(int id, String email, String first_name, String last_name, String avatar) {
        setId(id);
        setEmail(email);
        setFirst_name(first_name);
        setLast_name(last_name);
        setAvatar(avatar);
    }


//    // Used for POST requests - Create user - constructor java
//    public User(String name, String job) {
//        setLast_name(name);
//        setJob(job);
//    }

    //Used for POST requests - Register - Login
    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    // Used for POST requests - Unsuccessful login/register
    public User(String email) {
        setEmail(email);
    }

    // Used for DELETE requests - Remove user
    public User(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}

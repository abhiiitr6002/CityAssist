package com.example.ravi.cityassist;

/**
 * Created by abhishek on 10-Feb-16.
 */
public class dbaccess {

    private int _id;
    private String _username;
    private String _name;
    private int _age;
    private String _password;
    private String _email;

    public dbaccess(){

    }
    public dbaccess(String username,String name,int age,String password,String email){
        this._username = username;
        this._age = age;
        this._name = name;
        this._password = password;
        this._email = email;
    }

    public int get_id(){
        return _id;
    }

    public int get_age() {
        return _age;
    }

    public String get_email() {
        return _email;
    }

    public String get_name() {
        return _name;
    }

    public String get_username() {
        return _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_age(int _age) {
        this._age = _age;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}

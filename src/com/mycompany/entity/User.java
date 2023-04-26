/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

/**
 *
 * @author Ghssissine
 */
public class User {
    int wallet;
    String _id,username,email,password,address,birth;

    public User() {
    }

    public User(String birth, int wallet, String _id, String username, String email, String password, String address) {
        this.birth = birth;
        this.wallet = wallet;
        this._id = _id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(String birth, String _id, String username, String email, String password, String address) {
        this.birth = birth;
        this._id = _id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(int wallet, String _id, String username, String address) {
        this.wallet = wallet;
        this._id = _id;
        this.username = username;
        this.address = address;
    }

    public String getBirth() {
        return birth;
    }

    public int getWallet() {
        return wallet;
    }

    public String getId() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "birth=" + birth + ", wallet=" + wallet + ", _id=" + _id + ", username=" + username + ", email=" + email + ", password=" + password + ", address=" + address + '}';
    }
    
    
}

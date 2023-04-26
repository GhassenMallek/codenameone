/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;


/**
 *
 * @author Ghssissine
 * @param <T>
 */
public interface IAuthService <T> {
    public int signup(T t);
    public T login(T t);
    public void updatePass( T t);
    public int updateProfile(T t);
}

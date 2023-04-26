/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;

public class SignupForm extends Form {
    public SignupForm() {
        super(new BorderLayout());
        
        // Create a container for the logo image
        Container logoContainer = new Container(new LayeredLayout());
        logoContainer.setUIID("LogoContainer");
        
        // Create a container for the form fields
        Container formContainer = new Container(new GridLayout(3, 1));
        formContainer.setUIID("FormContainer");
        
        // Create text fields for the username and password
        TextField usernameField = new TextField("", "Username");
        TextField passwordField = new TextField("", "Password", 20, TextField.PASSWORD);
        
        // Add the text fields to the form container
        formContainer.add(usernameField);
        formContainer.add(passwordField);
        
        // Create a container for the buttons
        Container buttonContainer = new Container(new FlowLayout());
        buttonContainer.setUIID("ButtonContainer");
        
        // Create a "Sign up" button
        Button signupButton = new Button("Sign up");
        
        // Add an action listener to the "Sign up" button
        signupButton.addActionListener(e -> {
            // TODO: handle sign up logic
        });
        
        // Add the "Sign up" button to the button container
        buttonContainer.add(signupButton);
        
        // Create a "Cancel" button
        Button cancelButton = new Button("Cancel");
        
        // Add an action listener to the "Cancel" button
        cancelButton.addActionListener(e -> {
            // TODO: handle cancel logic
        });
        
        // Add the "Cancel" button to the button container
        buttonContainer.add(cancelButton);
        
        // Add the logo container, form container, and button container to the form
        add(BorderLayout.NORTH, logoContainer);
        add(BorderLayout.CENTER, formContainer);
        add(BorderLayout.SOUTH, buttonContainer);
        
        // Set the UIID for the form
        setUIID("SignupForm");
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.io.Preferences;
import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.*;
import com.mycompany.entity.User;
import com.mycompany.service.AuthService;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author macbookpro
 */
public class InscritForm extends Form {

    //Déclaration des variables
    private TextField usernameField;
    private TextField emailField;
    private TextField passwordField;
    private TextField dateDeNField;
    private TextArea adresseField;
    private Button annulerButton;
    private Button inscritButton;
    Picker datePicker;

    public InscritForm(Resources theme) {

        super(new BorderLayout());
        AuthService ls = new AuthService();
        //Creation de Form
        Form form = new Form("Inscription", new BorderLayout());

        // Load an image from the resources
        Image image = theme.getImage("minecraft.jpg");

        // Create the ImageView component with the image
        ImageViewer imageView = new ImageViewer(image);

        //changer la taille de l'image
        imageView.setPreferredH(600);
        imageView.setPreferredW(200);

        form.add(BorderLayout.CENTER, imageView);

        // Create UI components
        emailField = new TextField("", "Email", 20, TextField.ANY);
        passwordField = new TextField("", "mot de passe", 20, TextField.PASSWORD);
        usernameField = new TextField("", "Username", 20, TextField.ANY);
        dateDeNField = new TextField("", "Année de naissance", 20, TextField.ANY);

//        Picker datePicker = new Picker();
//        datePicker.setType(Display.PICKER_TYPE_DATE);
//        System.out.println(datePicker.getDate());

//        datePicker.setDate(new Date());
        adresseField = new TextArea();
        adresseField.setRows(5);
        adresseField.setHint("Adresse de facturation");

        // Create a container for the buttons
        Container buttonContainer = new Container(new FlowLayout(CENTER));

        // Create a "Inscrit" button
        inscritButton = new Button("S'inscrire");
        inscritButton.getAllStyles().setBorder(Border.createEmpty());
        inscritButton.getAllStyles().setBgTransparency(255);
        inscritButton.getAllStyles().setBgColor(0x2196F3);
        inscritButton.getAllStyles().setFgColor(0xFFFFFF);
        inscritButton.getAllStyles().setMargin(10, 10, 10, 10);

        // Add the "Inscrit" button to the button container
        buttonContainer.add(inscritButton);

        // Create a "Annuler" button
        annulerButton = new Button("Annuler");
        annulerButton.getAllStyles().setBorder(Border.createEmpty());
        annulerButton.getAllStyles().setBgTransparency(255);
        annulerButton.getAllStyles().setBgColor(0x2196F3);
        annulerButton.getAllStyles().setFgColor(0xFFFFFF);
        annulerButton.getAllStyles().setMargin(10, 10, 10, 10);

        //validator 
        Validator validator = new Validator();
        validator.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
        validator.addConstraint(emailField, RegexConstraint.validEmail());
        validator.addConstraint(passwordField, new LengthConstraint(3));
        validator.addConstraint(usernameField, new LengthConstraint(3));
        validator.addConstraint(dateDeNField, new LengthConstraint(3));
        validator.addConstraint(adresseField, new LengthConstraint(3));

        // Add an action listener to the "Inscrit" button
        inscritButton.addActionListener(e -> {
            // TODO: handle sign up logic
            if (validator.isValid()) {
                System.out.println("yup");
                
               User user= new User();
               user.setUsername(usernameField.getText());
               user.setEmail(emailField.getText());
               user.setPassword(passwordField.getText());
               user.setBirth(dateDeNField.getText());
               user.setAddress(adresseField.getText());

                int signUpFunc = ls.signup(user);
                if(signUpFunc == 201){
                    System.out.println("good");
                }
                 new LoginForm(theme).show();
                 
            } else {
                
                Dialog.show("Validation Error", "Vérifier les champs", "OK", null);
            }
        });

        // Add an action listener to the "Annuler" button
        annulerButton.addActionListener(e -> {
            // TODO: handle cancel logic
            new LoginForm(theme).show();
        });

        // Add the "Annuler" button to the button container
        buttonContainer.add(annulerButton);

        // Add components to form
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        centerContainer.add(form);
        centerContainer.add(usernameField);
        centerContainer.add(emailField);
        centerContainer.add(passwordField);
        centerContainer.add(dateDeNField);
//        centerContainer.add(datePicker);
        centerContainer.add(adresseField);
        centerContainer.add(buttonContainer);

        add(BorderLayout.CENTER, centerContainer);

    }

}

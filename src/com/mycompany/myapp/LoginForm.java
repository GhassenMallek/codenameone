package com.mycompany.myapp;

import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.validation.*;
import com.codename1.ui.util.Resources;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanButton;
import com.codename1.io.Preferences;
import com.codename1.ui.plaf.Border;
import com.mycompany.entity.User;
import com.mycompany.service.AuthService;

public class LoginForm extends Form {

    private TextField emailField;
    private TextField passwordField;
    private Button loginButton;
    private Button InscritButton;
    AuthService ls = new AuthService();

    public LoginForm(Resources theme) {
        super(new BorderLayout());

        // Create UI components
        emailField = new TextField("", "Email", 20, TextField.ANY);
        passwordField = new TextField("", "Mot de passe", 20, TextField.PASSWORD);

        //Button Login
        loginButton = new Button("S'authentifier");

        loginButton.getAllStyles().setBorder(Border.createEmpty());
        loginButton.getAllStyles().setBgTransparency(255);
        loginButton.getAllStyles().setBgColor(0x2196F3);
        loginButton.getAllStyles().setFgColor(0xFFFFFF);
        loginButton.getAllStyles().setMargin(10, 10, 10, 10);

        //Button Inscrit
        InscritButton = new Button("Créer un compte");

        InscritButton.getAllStyles().setBorder(Border.createEmpty());
        InscritButton.getAllStyles().setBgTransparency(255);
        InscritButton.getAllStyles().setBgColor(0xF3212D);
        InscritButton.getAllStyles().setFgColor(0xFFFFFF);
        InscritButton.getAllStyles().setMargin(10, 10, 10, 10);

        //Creation de Form
        Form form = new Form("S'authentifier", new BorderLayout());
        // Load an image from the resources
        Image image = theme.getImage("minecraft.jpg");

        // Create the ImageView component with the image
        ImageViewer imageView = new ImageViewer(image);

        //changer la taille de l'image
        imageView.setPreferredH(600);
        imageView.setPreferredW(200);

        form.add(BorderLayout.CENTER, imageView);

        //create a SpanButton
        SpanButton spanButton = new SpanButton("Oublier mot de passe");
        spanButton.addActionListener(evt -> new OublierForm(theme).show());

        // Add components to form
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        centerContainer.add(form);
        centerContainer.add(emailField);
        centerContainer.add(passwordField);
        centerContainer.add(loginButton);
        centerContainer.add(InscritButton);
        centerContainer.add(spanButton);
        add(BorderLayout.CENTER, centerContainer);

        //validator pour l'email
//        Validator valEmail = new Validator();
//        valEmail.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
//        valEmail.addConstraint(emailField, RegexConstraint.validEmail());
        //validator pour le mote de passe
        Validator valPassword = new Validator();
        valPassword.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
        valPassword.addConstraint(passwordField, new LengthConstraint(3));

        // Set login button action
        loginButton.addActionListener(e -> {

//            if (valEmail.isValid()) {
//              System.out.println("Email field passes the constraint");
            if (valPassword.isValid()) {
               
                // new InscritForm().show();
                User user  = new  User();
                user.setEmail(emailField.getText());
                user.setPassword(passwordField.getText());
                        
                User login = ls.login(user);
                System.out.println(login);
                 Preferences.set("email", user.getEmail());
                 Preferences.set("password", user.getPassword());
                 Preferences.set("id",user.getId());
//                if (ls.login(user).request.getResponseCode() == 200) {
//                   
//                  // direction ghassen   
//                    System.out.println("heey");
//                }
            } else {
                Dialog.show("Validation Error", " Vérifier le champs mote de passe ", "OK", null);
            }
//            } 
//                else {
//                Dialog.show("Validation Error", "Vérifier le champs Email " , "OK", null);
//            }
        });

        // Set Inscrit button action
        InscritButton.addActionListener(e -> {

            new InscritForm(theme).show();
        });
    }
}

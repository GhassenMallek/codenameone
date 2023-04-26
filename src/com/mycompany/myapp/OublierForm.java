/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.entity.User;
import com.mycompany.service.AuthService;

/**
 *
 * @author macbookpro
 */
public class OublierForm extends Form{
    //Déclaration des variables
    private TextField usernameField;
    private Button suivantButton;
    AuthService ls = new AuthService();

    public OublierForm(Resources theme) {
        super(new BorderLayout());
        Toolbar.setGlobalToolbar(true);
      
        //Creation de Form
        Form form = new Form("Réinitialiser le mot de passe", new BorderLayout());
        //Ajouter la bouton retourne
        form.getToolbar().addCommandToLeftBar("", theme.getImage("icons8-back-arrow-90.png"), (e) ->new LoginForm(theme).show());
        
        // Load an image from the resources
        Image image = theme.getImage("minecraft.jpg");
        
        // Create the ImageView component with the image
        ImageViewer imageView = new ImageViewer(image);
        
        //changer la taille de l'image
        imageView.setPreferredH(600);
        imageView.setPreferredW(200);
      
        form.add(BorderLayout.CENTER, imageView); 
        
        // Create UI components
        usernameField = new TextField("", "Username", 20, TextField.ANY);
        
         //Button suivant
        suivantButton = new Button("Réinitialiser le mot de passe");
        
        suivantButton.getAllStyles().setBorder(Border.createEmpty());
        suivantButton.getAllStyles().setBgTransparency(255);
        suivantButton.getAllStyles().setBgColor(0x2196F3);
        suivantButton.getAllStyles().setFgColor(0xFFFFFF);
        suivantButton.getAllStyles().setMargin(10, 10, 10, 10);
        
        
        //validator 
        Validator validator = new Validator();
        validator.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
        validator.addConstraint(usernameField, new LengthConstraint(3));
        
        
         // Add an action listener to the "Suivant" button
        suivantButton.addActionListener(e -> {
            // TODO: handle sign up logic
            if (validator.isValid()) {
               new ParametreForm(theme).show();
               User user = new User();
               user.setUsername(usernameField.getText());
              ls.updatePass(user);
            } else {
                Dialog.show("Validation Error", "Vérifier le champ Username" , "OK", null);
            }
        });
        
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        centerContainer.add(form);
        centerContainer.add(usernameField);
        centerContainer.add(suivantButton);
        
         add(BorderLayout.CENTER, centerContainer);
    }  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.Validator;
import com.mycompany.entity.User;
import com.mycompany.service.AuthService;

/**
 *
 * @author macbookpro
 */
public class ParametreForm extends Form{
    
    private TextField passwordActuelField;
    private TextField NouveauPasswordField;
    private TextArea adresseField;
    private Button saveButton;
    AuthService ls = new AuthService();
User user = new User();
    public ParametreForm(Resources theme) {
        super(new BorderLayout());
         Toolbar.setGlobalToolbar(true);
         
          //Creation de Form
        Form form = new Form("Paramètres du profil", new BorderLayout());
        //Ajouter la bouton retourne
        form.getToolbar().addCommandToLeftBar("", theme.getImage("icons8-back-arrow-90.png"), (e) ->new OublierForm(theme).show());
        
        // Load an image from the resources
        Image image = theme.getImage("minecraft.jpg");
        
        // Create the ImageView component with the image
        ImageViewer imageView = new ImageViewer(image);
        
        //changer la taille de l'image
        imageView.setPreferredH(600);
        imageView.setPreferredW(200);
      
        form.add(BorderLayout.CENTER, imageView); 
        
         // Create UI components
        passwordActuelField = new TextField("", "Mot de passe actuel", 20, TextField.ANY);
        NouveauPasswordField = new TextField("", "Nouveau mot de passe", 20, TextField.ANY);
        adresseField = new TextArea();
        adresseField.setRows(5);
        adresseField.setHint("Adresse de facturation");
        
         //Button suivant
        saveButton = new Button("Enregistrer");
        
        saveButton.getAllStyles().setBorder(Border.createEmpty());
        saveButton.getAllStyles().setBgTransparency(255);
        saveButton.getAllStyles().setBgColor(0x2196F3);
        saveButton.getAllStyles().setFgColor(0xFFFFFF);
        saveButton.getAllStyles().setMargin(10, 10, 10, 10);
        
        
        //validator 
        Validator validator = new Validator();
        validator.setValidationFailureHighlightMode(Validator.HighlightMode.UIID);
        validator.addConstraint(passwordActuelField, new LengthConstraint(4));
        validator.addConstraint(NouveauPasswordField, new LengthConstraint(4));
        validator.addConstraint(adresseField, new LengthConstraint(4));
        
        
         // Add an action listener to the "Suivant" button
        saveButton.addActionListener(e -> {
            // TODO: handle sign up logic
            if (validator.isValid()) {
                 user.setUsername(passwordActuelField.getText());
               user.setEmail(adresseField.getText());
                ls.updateProfile(user);
                
                Dialog.show("Validation Succes", "formulaire bien saisire" , "OK", null);
              
            } else {
                Dialog.show("Validation Error", "Vérifier les champs" , "OK", null);
            }
        });
        
        Container centerContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        centerContainer.add(form);
        centerContainer.add(passwordActuelField);
        centerContainer.add(NouveauPasswordField);
        centerContainer.add(adresseField);
        centerContainer.add(saveButton);
        
         add(BorderLayout.CENTER, centerContainer);
        
    }
  
    
}

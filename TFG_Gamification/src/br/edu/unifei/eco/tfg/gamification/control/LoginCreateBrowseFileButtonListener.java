/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author wkuan
 */
public class LoginCreateBrowseFileButtonListener implements ActionListener{
    private Form parentForm = null;
    private TextField txtField = null;
    public LoginCreateBrowseFileButtonListener(Form parent, TextField txtField){
        this.parentForm = parent;
        this.txtField = txtField;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        ActionListener callback = e->{
        if (e != null && e.getSource() != null) {
                String filePath = (String)e.getSource();
                txtField.setText(filePath);
            }
        };
        Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
    }
}

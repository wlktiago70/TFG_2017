/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.LoginStartButtonListener;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Login extends Form{
    private Container cnt = new Container();
    private final Label lblUser = new Label("User");
    private final Label lblPassword = new Label("Password");
    private final TextField txfUser = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private final TextField txfPassword = new TextField("","Your password",30,TextField.PASSWORD);
    private final Button btnStart = new Button("Let's start!");
    private final Button btnSignUp = new Button("Sign up");
    private final Label icon;
    private boolean login = false;
    public Login() throws IOException{
        super("Welcome", new FlowLayout(Component.CENTER));
        btnStart.setUIID("GreenButton");
        this.icon = new Label(Image.createImage("/img.png").scaled(150,150));        
        this.add(icon);
        cnt.add(lblUser);
        cnt.add(txfUser);
        cnt.add(lblPassword);
        cnt.add(txfPassword);
        this.add(cnt);
        this.add(btnSignUp);
        btnStart.addActionListener(new LoginStartButtonListener(this,txfUser.getText(),txfPassword.getText()));
        this.add(btnStart);
        this.show();
    }
    public Button getBtnStart(){
        return btnStart;
    }
    public Button getBtnSignUp(){
        return btnSignUp;
    }
    public TextField getTxfUser(){
        return txfUser;
    }
    public TextField getTxfPassword(){
        return txfPassword;
    }
}

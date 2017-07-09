/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 *
 * @author User
 */
public class Login extends Form{
    private Container cnt = new Container(new FlowLayout());
    private final Label lblUser = new Label("User");
    private final Label lblPassword = new Label("Password");
    private final TextField txfUser = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private final TextField txfPassword = new TextField("","Your password",30,TextField.PASSWORD);
    private final Button btnStart = new Button("Let's Start!");
    public Login(){
        super("Welcome", new FlowLayout());
        this.add(lblUser);
        this.add(txfUser);
        this.add(lblPassword);
        this.add(txfPassword);
        this.add(btnStart);
        this.show();
    }
}

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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;

/**
 *
 * @author User
 */
public class Login extends Form{
    private Container cnt = new Container(new GridLayout(4,1));
    private final Label lblUser = new Label("User");
    private final Label lblPassword = new Label("Password");
    private final TextField txfUser = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private final TextField txfPassword = new TextField("","Your password",30,TextField.PASSWORD);
    private final Button btnClear = new Button("Clear");
    private final Button btnStart = new Button("Let's Start!");
    private boolean login = false;
    public Login(){
        super("Welcome", new FlowLayout());
        cnt.add(lblUser);
        cnt.add(txfUser);
        cnt.add(lblPassword);
        cnt.add(txfPassword);
        this.add(cnt);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                txfUser.clear();
                txfPassword.clear();
            }
        });
        this.add(btnClear);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //Validate the login information
            }
        });
        this.add(btnStart);
        this.show();
    }
}

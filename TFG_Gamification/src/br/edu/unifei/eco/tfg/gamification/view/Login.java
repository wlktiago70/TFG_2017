/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.LoginSignUpButtonListener;
import br.edu.unifei.eco.tfg.gamification.control.LoginStartButtonListener;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.table.TableLayout;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Login extends Form{
    private final Label lblUser = new Label("User");
    private final Label lblPassword = new Label("Password");
    private final TextField txfUser = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private final TextField txfPassword = new TextField("","Your password",30,TextField.PASSWORD);
    private final Button btnStart = new Button("Let's start!");
    private final Button btnSignUp = new Button("Sign up");
    private final Label icon;
    private TableLayout tabLyt = new TableLayout(6,2);
    private boolean login = false;
    public Login() throws IOException{
        super("Welcome");
        this.setLayout(tabLyt);
        btnStart.setUIID("GreenButton");
        icon = new Label(Image.createImage("/YourLogoHere.jpg").scaled(550,350));
        this.add(tabLyt.createConstraint().heightPercentage(35).verticalAlign(CENTER).horizontalAlign(CENTER).horizontalSpan(2),icon)
            .add(tabLyt.createConstraint().horizontalSpan(2),lblUser)
            .add(tabLyt.createConstraint().horizontalSpan(2),txfUser)
            .add(tabLyt.createConstraint().horizontalSpan(2),lblPassword)
            .add(tabLyt.createConstraint().horizontalSpan(2),txfPassword)
            .add(tabLyt.createConstraint().widthPercentage(50).heightPercentage(15).verticalAlign(CENTER).horizontalAlign(CENTER),btnSignUp)
            .add(tabLyt.createConstraint().widthPercentage(50).heightPercentage(15).verticalAlign(CENTER).horizontalAlign(CENTER),btnStart);
        btnSignUp.addActionListener(new LoginSignUpButtonListener(this));
        btnStart.addActionListener(new LoginStartButtonListener(this,txfUser.getText(),txfPassword.getText()));
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

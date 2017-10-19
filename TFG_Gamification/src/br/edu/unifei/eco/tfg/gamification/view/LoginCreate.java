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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author wkuan
 */
public class LoginCreate extends TemplateForm{
    private Container cntContent;
    private TextField txfUserName = new TextField("","Your name",30,TextField.ANY);
    private TextField txfUserMail = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private TextField txfUserPass = new TextField("","Your password",30,TextField.PASSWORD);
    private TextField txfUserPassConf = new TextField("","Confirm your password",30,TextField.PASSWORD);
    private TextArea txaSelfIntro = new TextArea(30,30);
    private Button btnCreate = new Button("Create");   
    private TableLayout tblLyt = new TableLayout(3,1);
    public LoginCreate(Form parent){
        super(parent,"SignUp",new BorderLayout());
        cntContent = new Container(tblLyt);
        cntContent.add(TableLayout.encloseIn(2, new Label("Name: "),txfUserName,
                                                new Label("E-mail: "),txfUserMail,
                                                new Label("Introduction: "),new Label("")))
                  .add(tblLyt.createConstraint().heightPercentage(25),txaSelfIntro)
                  .add(TableLayout.encloseIn(2, new Label("Password: "),txfUserPass,
                                                new Label("Confirm password: "),txfUserPassConf));
        
        this.add(BorderLayout.CENTER,cntContent).add(BorderLayout.SOUTH,btnCreate);
        this.show();
    }

    public Button getBtnCreate() {
        return btnCreate;
    }
    
}

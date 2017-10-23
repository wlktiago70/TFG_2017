/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.LoginCreateBrowseFileButtonListener;
import com.codename1.components.MultiButton;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.list.GenericListCellRenderer;
import com.codename1.ui.table.TableLayout;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wkuan
 */
public class LoginCreate extends TemplateForm{
    private Container cntContent;
    private TextField txfUserName = new TextField("","Your name",30,TextField.ANY);
    private TextField txfFilePath = new TextField("","Your photo",30,TextField.ANY);
    private TextField txfUserMail = new TextField("","Your e-mail",30,TextField.EMAILADDR);
    private TextField txfUserPass = new TextField("","Your password",30,TextField.PASSWORD);
    private TextField txfUserPassConf = new TextField("","Confirm your password",30,TextField.PASSWORD);
    private TextArea txaSelfIntro = new TextArea(30,30);
    private Button btnSelectFile = new Button("Browse...");   
    private Button btnCreate = new Button("Create");   
    private TableLayout tblLyt = new TableLayout(3,1);
    private ComboBox<Map<String, Object>> combo;
    public LoginCreate(Form parent){
        super(parent,parent,"SignUp",new BorderLayout());      
        
        btnSelectFile.addActionListener(new LoginCreateBrowseFileButtonListener(this,txfFilePath));       
        
        combo = new ComboBox<> (
          createListEntry("Computer Engineering", "ECO"),
          createListEntry("Control and Automation Engineering", "ECA"),
          createListEntry("Electrical Engineering", "EEL"),
          createListEntry("Electronic", "ELT"),
          createListEntry("Mechanical Engineering", "EME"),
          createListEntry("Material Engineering", "EMA"),
          createListEntry("Industrial Engineering", "EPR"));
        //When using list ->   combo.addItem(createListEntry("Computer Engineering", "ECO"));
        combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Log.p(combo.getSelectedItem().toString());
            }
        });
        combo.setUIID("Button");
        cntContent = new Container(tblLyt);
        cntContent.add(TableLayout.encloseIn(2, new Label("Name: "),txfUserName,
                                                new Label("E-mail: "),txfUserMail,
                                                btnSelectFile,txfFilePath,
                                                new Label("Occupation: "),combo,
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
    private Map<String, Object> createListEntry(String name, String abbr) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", abbr);
        return entry;
    }
}

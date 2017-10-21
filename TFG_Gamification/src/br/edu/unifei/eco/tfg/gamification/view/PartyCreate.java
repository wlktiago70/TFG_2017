/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author wkuan
 */
public class PartyCreate extends TemplateForm{
    private Container cntNorth;            
    private Container cntNorthTypes = new Container(new GridLayout(1,4));            
    private Container cntCenter = new Container(new FlowLayout(Component.CENTER));
    private TextField txfPartyTitle = new TextField();
    private int typeSel = 0;
    private TextArea txaDescription = new TextArea(30,30);
    private Button btnCreate = new Button("Create");
    private Button btnSideQuest = new Button("Side quests");
    private Button btnInvitePlayer = new Button("Invite players");    
    private TableLayout tblLyt = new TableLayout(4,1);
    public PartyCreate(TemplateForm parent){
        super(parent,parent.getHomeForm(),"Party",new BorderLayout());
        cntNorth = TableLayout.encloseIn(2, new Label("Title: "),txfPartyTitle,
                                            new Label("Description: "),new Label(""));
        cntCenter.setLayout(tblLyt);
        cntCenter.add(tblLyt.createConstraint().heightPercentage(15), cntNorth)
                 .add(tblLyt.createConstraint().heightPercentage(20), txaDescription)
                 .add(btnSideQuest)
                 .add(btnInvitePlayer);
        
        this.add(BorderLayout.CENTER,cntCenter).add(BorderLayout.SOUTH,btnCreate);
        this.show();
    }
    
    public TextField getTxfPartyTitle() {
        return txfPartyTitle;
    }    

    public TextArea getTxaDescription() {
        return txaDescription;
    }

    public Button getBtnCreate() {
        return btnCreate;
    }
    
}

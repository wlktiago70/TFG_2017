/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.PartyCreateButtonListener;
import com.codename1.components.Accordion;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.TableLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class Party extends TemplateForm{
    private List<Container> cntParties = new ArrayList<>();
    private TextArea txaDescription = new TextArea(30,30);
    private Accordion partyList = new Accordion();
    private Button btnCreateParty = new Button("Create party");
    private Button btnLeaveParty = new Button("Leave party");
    private Button btnSideQuest = new Button("Side quests");
    private Button btnMembers = new Button("Party members");
    private TableLayout tblLyt = new TableLayout(4,1);
    public Party(TemplateForm parent, String strPartyName, String strOwner, String strDescription){
        super(parent,parent.getHomeForm(),"Parties", new BorderLayout());
        addComponentToContainer(strPartyName,strOwner,strDescription);                
        for (Container cntParty : cntParties) partyList.addContent(new Label(strPartyName),cntParty);        
        partyList.expand(cntParties.get(0));//Expand first
        btnCreateParty.addActionListener(new PartyCreateButtonListener(this));
        this.add(BorderLayout.CENTER, partyList);
        this.add(BorderLayout.SOUTH, btnCreateParty);
        this.setVisible(true);
    }
    private void addComponentToContainer(String strPartyName, String strOwner, String strDescription){
        Container cnt = new Container(tblLyt);
        btnLeaveParty.setUIID("RedButton");
        Container cntNorth = TableLayout.encloseIn(2, new Label("Owner: "),new Label(strOwner),
                                                      new Label("Description: "),new Label(""));
        TextArea txaDescription = new TextArea(30,30);
        txaDescription.setText(strDescription);
        txaDescription.setEditable(false);        
        cnt.add(tblLyt.createConstraint().heightPercentage(15),cntNorth)
           .add(tblLyt.createConstraint().heightPercentage(20).verticalAlign(TOP),txaDescription)
           .add(btnSideQuest)
           .add(btnMembers)
           .add(btnLeaveParty);
        cntParties.add(cnt);
    }
}

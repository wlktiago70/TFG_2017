/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.MissionCreateButtonListener;
import com.codename1.components.Accordion;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.table.TableLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class Party extends TemplateForm{
    private Container cntParties = new Container();
    private Container cntParty;//It is just for one element
    private TextArea txaDescription = new TextArea(30,30);
    private Accordion partyList = new Accordion();
    private Button btnCreateParty = new Button("Create party");
    public Party(TemplateForm parent, String strPartyName, String strOwner, List<String> lstMembers, String strDescription){
        super(parent,"Parties", new BorderLayout());
        addComponentToContainer(strPartyName,strOwner,lstMembers,strDescription);                
        partyList.addContent(new Label(strPartyName),cntParty);
        partyList.expand(cntParty);//Expand first
        btnCreateParty.addActionListener(new MissionCreateButtonListener(this));
        this.add(BorderLayout.CENTER, partyList);
        this.add(BorderLayout.SOUTH, btnCreateParty);
        this.setVisible(true);
    }
    private void addComponentToContainer(String strPartyName, String strOwner, List<String> lstMembers, String strDescription){
        Container cnt = new Container(new BorderLayout());
        Container cntNorthMembers = new Container(new FlowLayout());
        for (String lstMember : lstMembers) cntNorthMembers.add(new Label(lstMember));
        Container cntNorth = TableLayout.encloseIn(2, new Label("Owner: "),new Label(strOwner),
                                            new Label("Members: "),cntNorthMembers,
                                            new Label("Description: "),new Label(""));
        TextArea txaDescription = new TextArea(30,30);
        txaDescription.setText(strDescription);
        txaDescription.setEditable(false);
        cnt.add(BorderLayout.NORTH,cntNorth);
        cnt.add(BorderLayout.CENTER,txaDescription);
        cntParty = cnt;//When using list, add 'cnt'.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.MissionCreateButtonListener;
import com.codename1.components.Accordion;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class Mission extends TemplateForm{
    private Container cntMissions = new Container();
    private Container cntVolunteering;
    private Container cntInstructional;
    private Container cntAthletics;
    private Container cntCultural;
    private Container cntOthers;
    private Label lblVol = new Label("Volunteering",FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblIns = new Label("Instructional",FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblAth = new Label("Athletics",FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblCul = new Label("Cultural",FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblOth = new Label("Others",FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("Label")));
    private List<Button> btnVol = new ArrayList<>();
    private List<Button> btnIns = new ArrayList<>();
    private List<Button> btnAth = new ArrayList<>();
    private List<Button> btnCul = new ArrayList<>();
    private List<Button> btnOth = new ArrayList<>();
    private Accordion missionList = new Accordion();
    private BoxLayout boxlyt = new BoxLayout(BoxLayout.Y_AXIS);
    private Button btnCreateMission = new Button("Create mission");
    public Mission(TemplateForm parent, List<String> lstVol, List<String> lstIns, List<String> lstAth, List<String> lstCul, List<String> lstOth){
        super(parent,"Missions", new BorderLayout());
        cntVolunteering = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntInstructional = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntAthletics = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntCultural = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntOthers = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        addComponentToContainer(lstVol,btnVol,cntVolunteering);
        addComponentToContainer(lstIns,btnIns,cntInstructional);
        addComponentToContainer(lstAth,btnAth,cntAthletics);
        addComponentToContainer(lstCul,btnCul,cntCultural);
        addComponentToContainer(lstOth,btnOth,cntOthers);
        lblVol.setTextPosition(Component.RIGHT);
        lblIns.setTextPosition(Component.RIGHT);
        lblAth.setTextPosition(Component.RIGHT);
        lblCul.setTextPosition(Component.RIGHT);
        lblOth.setTextPosition(Component.RIGHT);
        missionList.addContent(lblVol,cntVolunteering);
        missionList.addContent(lblIns,cntInstructional);
        missionList.addContent(lblAth,cntAthletics);
        missionList.addContent(lblCul,cntCultural);
        missionList.addContent(lblOth,cntOthers);
        btnCreateMission.addActionListener(new MissionCreateButtonListener(this));
        this.add(BorderLayout.CENTER, missionList);
        this.add(BorderLayout.SOUTH, btnCreateMission);
        this.setVisible(true);
    }
    private void addComponentToContainer(List<String> lstStr, List<Button> lstBtn, Container cnt){
        for(String str: lstStr){
            Button btn = new Button(str);
            lstBtn.add(btn);
            cnt.add(btn);
            btn.addActionListener((e) -> Log.p(e.getSource().toString()+" Clicked"));
        }
    }
}

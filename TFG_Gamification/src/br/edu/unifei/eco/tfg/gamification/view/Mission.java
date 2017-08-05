/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.SearchButtonListener;
import com.codename1.components.Accordion;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class Mission extends Form{
    private static Form parentForm;
    private Container cntMissions = new Container();
    private Container cntVolunteering;
    private Container cntInstructional;
    private Container cntAthletics;
    private Container cntCultural;
    private Label lblVol = new Label("Voluteering",FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblIns = new Label("Instructional",FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblAth = new Label("Athletics",FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("Label")));
    private Label lblCul = new Label("Cultural",FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("Label")));
    private List<Button> btnVol = new ArrayList<>();
    private List<Button> btnIns = new ArrayList<>();
    private List<Button> btnAth = new ArrayList<>();
    private List<Button> btnCul = new ArrayList<>();
    private Accordion missionList = new Accordion();
    private BoxLayout boxlyt = new BoxLayout(BoxLayout.Y_AXIS);
    private Button btnCreateMission = new Button("Create mission");
    public Mission(Form parent, List<String> lstVol, List<String> lstIns, List<String> lstAth, List<String> lstCul){
        super("Mission", new BorderLayout());
        configureToolbar();
        parentForm = parent;
        cntVolunteering = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntInstructional = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntAthletics = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cntCultural = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        addComponentToContainer(lstVol,btnVol,cntVolunteering);
        addComponentToContainer(lstIns,btnIns,cntInstructional);
        addComponentToContainer(lstAth,btnAth,cntAthletics);
        addComponentToContainer(lstCul,btnCul,cntCultural);
        lblVol.setTextPosition(Component.RIGHT);
        lblIns.setTextPosition(Component.RIGHT);
        lblAth.setTextPosition(Component.RIGHT);
        lblCul.setTextPosition(Component.RIGHT);
        missionList.addContent(lblVol,cntVolunteering);
        missionList.addContent(lblIns,cntInstructional);
        missionList.addContent(lblAth,cntAthletics);
        missionList.addContent(lblCul,cntCultural);
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
    private void configureToolbar(){
        Toolbar.setGlobalToolbar(true);
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        this.getToolbar().addCommandToLeftBar("", FontImage.createMaterial(FontImage.MATERIAL_HOME, s), (e) -> parentForm.showBack());
        this.getToolbar().addCommandToSideMenu("Logout", null, (e) -> ((Home)parentForm).getParentForm().showBack());
        this.getToolbar().addSearchCommand(new SearchButtonListener(this), 3);
    }
}

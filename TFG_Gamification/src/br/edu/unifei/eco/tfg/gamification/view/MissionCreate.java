/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author wkuan
 */
public class MissionCreate extends TemplateForm{
    public static final int VOLUNTEERING = 1;
    public static final int INSTRUCTIONAL = 2;
    public static final int ATHLETICS = 3;
    public static final int CULTURAL = 4;
    public static final int OTHERS = 5;
    private Container cntNorth;            
    private Container cntNorthTypes = new Container(new GridLayout(1,5));            
    private Container cntCenter = new Container(new FlowLayout(Component.CENTER));
    private TextField txfMissionTitle = new TextField();
    private Label lblVol = new Label(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("TitleCommand")));
    private Label lblIns = new Label(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("TitleCommand")));
    private Label lblAth = new Label(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("TitleCommand")));
    private Label lblCul = new Label(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("TitleCommand")));
    private Label lblOth = new Label(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")));
    private int typeSel = 0;
    private TextField txfDueDate = new TextField("","DD / MM / YYYY",10,TextField.ANY);
    private TextArea txaDescription = new TextArea(30,30);
    private Button btnCreate = new Button("Create");
    public MissionCreate(TemplateForm parent){
        super(parent,parent.getHomeForm(),"Mission",new BorderLayout());
        cntNorthTypes.add(lblVol).add(lblIns).add(lblAth).add(lblCul).add(lblOth);
        cntNorth = TableLayout.encloseIn(2, new Label("Title: "),txfMissionTitle,
                                            new Label("Type: "),cntNorthTypes,
                                            new Label("Due date: "),txfDueDate,
                                            new Label("Description: "),new Label(""));
        cntCenter.add(txaDescription);
        lblVol.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVol.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("Label")));
                lblIns.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblAth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblCul.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblOth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                typeSel = MissionCreate.VOLUNTEERING;
                Log.p("Type selected = "+typeSel);
            }
        });
        lblIns.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVol.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblIns.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("Label")));
                lblAth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblCul.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblOth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                typeSel = MissionCreate.INSTRUCTIONAL;
                Log.p("Type selected = "+typeSel);
            }
        });
        lblAth.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVol.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblIns.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblAth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("Label")));
                lblCul.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblOth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                typeSel = MissionCreate.ATHLETICS;
                Log.p("Type selected = "+typeSel);
            }
        });
        lblCul.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVol.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblIns.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblAth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblCul.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("Label")));
                lblOth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                typeSel = MissionCreate.CULTURAL;
                Log.p("Type selected = "+typeSel);
            }
        });
        lblOth.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblVol.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MOOD, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblIns.setIcon(FontImage.createMaterial(FontImage.MATERIAL_SCHOOL, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblAth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_FAVORITE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblCul.setIcon(FontImage.createMaterial(FontImage.MATERIAL_PALETTE, UIManager.getInstance().getComponentStyle("TitleCommand")));
                lblOth.setIcon(FontImage.createMaterial(FontImage.MATERIAL_LIBRARY_ADD, UIManager.getInstance().getComponentStyle("Label")));
                typeSel = MissionCreate.OTHERS;
                Log.p("Type selected = "+typeSel);
            }
        });
        txfDueDate.addDataChangedListener(new DataChangedListener() {
            @Override
            public void dataChanged(int type, int index) {
                String str = txfDueDate.getText();
                Date date;
                if(type == DataChangedListener.ADDED || type == DataChangedListener.CHANGED){
                    try{
                        if(str.length()>=1)
                            Integer.parseInt(str);
                        if(str.length()>=8){
                            str = str.substring(0,2)+"/"+str.substring(2,4)+"/"+str.substring(4);
                            date = new SimpleDateFormat("dd/MM/yyyy").parse(str);
                        }
                    }catch(Exception e){
                        txfDueDate.clear(); 
                    }
                }
            }
        });
        this.add(BorderLayout.NORTH,cntNorth).add(BorderLayout.CENTER,cntCenter).add(BorderLayout.SOUTH,btnCreate);
        this.show();
    }
    
    public int getTypeSel(){
        return typeSel;
    }

    public TextField getTxfMissionTitle() {
        return txfMissionTitle;
    }

    public TextField getTxfDueDate() {
        return txfDueDate;
    }

    public TextArea getTxaDescription() {
        return txaDescription;
    }

    public Button getBtnCreate() {
        return btnCreate;
    }
    
}

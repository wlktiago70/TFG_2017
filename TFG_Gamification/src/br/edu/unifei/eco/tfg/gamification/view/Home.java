/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.*;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
public class Home extends TemplateForm{
    private String userName;
    private int userScore;
    private Image userPhoto;
    private Label lblUserName;
    private Label lblUserScore;
    private Label lblUserPhoto;
    private List<Image> mainAchievements;
    private static Container cntAchiev = new Container(new GridLayout(1,3));
    private static Container cntNorth = new Container(new BorderLayout());
    private static Container cntCenter = new Container(new BorderLayout());
    private static Container cntCenter_Grid = new Container(new GridLayout(2,1));
    private static Container cntSouth = new Container(new GridLayout(1,4));
    private static Container cntUser = new Container(new BorderLayout());
    private static Container cntUserInfo = new Container(new GridLayout(2,1));
    private static Button btnMission = new Button("Missions");
    private static Button btnParty = new Button("Party");
    private static Image[] imgHouses = new Image[4];
    public Home(Form parent, String name, int score, Image photo, List<Image> achievements){
        super(parent,"Home",new BorderLayout());
        userName = name;
        userScore = score;
        userPhoto = photo;
        mainAchievements = achievements;
        processImages();
        lblUserName = new Label(userName);
        lblUserScore = new Label("Total Score: "+Integer.toString(userScore));
        lblUserPhoto = new Label(userPhoto);
        lblUserName.addPointerPressedListener(new HomeUserComponentListener(this));
        lblUserScore.addPointerPressedListener(new HomeUserComponentListener(this));
        lblUserPhoto.addPointerPressedListener(new HomeUserComponentListener(this));
        lblUserName.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        lblUserScore.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_LARGE));        
        btnMission.setIcon(FontImage.createMaterial(FontImage.MATERIAL_CENTER_FOCUS_STRONG, UIManager.getInstance().getComponentStyle("Button")));
        btnParty.setIcon(FontImage.createMaterial(FontImage.MATERIAL_GROUP, UIManager.getInstance().getComponentStyle("Button")));
        btnMission.addActionListener(new HomeMissionButtonListener(this));
        btnParty.addActionListener(new HomePartyButtonListener(this));
        //Add content to containers
        cntUserInfo.add(lblUserName);
        cntUserInfo.add(lblUserScore);
        cntUser.add(BorderLayout.WEST, lblUserPhoto);
        cntUser.add(BorderLayout.CENTER, cntUserInfo);
        cntUser.setWidth(this.getWidth());
        for (Image achievement : mainAchievements){
            Label lblAux = new Label(achievement);
            lblAux.getStyle().setAlignment(Component.CENTER);
            lblAux.addPointerPressedListener(new HomeAchievementComponentListener(this));
            cntAchiev.add(lblAux);
        }
        cntNorth.add(BorderLayout.CENTER,cntUser);        
        cntCenter_Grid.add(btnMission);
        cntCenter_Grid.add(btnParty);
        cntCenter.add(BorderLayout.NORTH,cntAchiev);
        cntCenter.add(BorderLayout.CENTER,cntCenter_Grid);
        for (Image imgHouse : imgHouses){
            Label lblAux = new Label(imgHouse);
            lblAux.getStyle().setAlignment(Component.CENTER);
            lblAux.addPointerPressedListener(new HomeHouseComponentListener(this));
            cntSouth.add(lblAux);
        }
        this.add(BorderLayout.NORTH, cntNorth);
        this.add(BorderLayout.CENTER, cntCenter);
        this.add(BorderLayout.SOUTH, cntSouth);       
        
        this.show();
    }
    private void processImages(){
        //User profile image
        int width = 85;
        userPhoto = userPhoto.scaledWidth(width);
        Image roundMask = Image.createImage(width, userPhoto.getHeight(), 0xff000000);
        Graphics gr = roundMask.getGraphics();
        gr.setColor(0xffffff);
        gr.fillArc(0, 0, width, width, 0, 360);
        Object mask = roundMask.createMask();
        userPhoto = userPhoto.applyMask(mask);
        //Houses images
        width = 65;
        try {
            Image houses = Image.createImage("/4houses.jpg").scaled(2*width,2*width);
            Image roundSquareMask = Image.createImage("/#sqrMask.png").scaled(width,width);
            mask = roundSquareMask.createMask();
            imgHouses[0] = houses.subImage(0, 0, width, width, false);
            imgHouses[1] = houses.subImage(houses.getWidth()/2, 0, width, width, false);
            imgHouses[2] = houses.subImage(0, houses.getHeight()/2, width, width, false);
            imgHouses[3] = houses.subImage(houses.getWidth()/2, houses.getHeight()/2, width, width, false);
            imgHouses[0] = imgHouses[0].applyMask(mask);
            imgHouses[1] = imgHouses[1].applyMask(mask);
            imgHouses[2] = imgHouses[2].applyMask(mask);
            imgHouses[3] = imgHouses[3].applyMask(mask);
        } catch (IOException ex) {
            System.out.println("Error when processing images: An IOException occurred.");
        }

    }
}

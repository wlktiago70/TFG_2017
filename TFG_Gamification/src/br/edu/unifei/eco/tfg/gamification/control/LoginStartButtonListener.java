/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import br.edu.unifei.eco.tfg.gamification.view.Home;
import br.edu.unifei.eco.tfg.gamification.view.TemplateForm;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class LoginStartButtonListener implements ActionListener{
    private String usr,pwd;
    private Form parentForm = null;
    private Form descendantForm = null;
    public LoginStartButtonListener(Form parent, String user, String password){
        usr = user;
        pwd = password;
        parentForm = parent;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(isValidUser()){
            if(descendantForm != null){
                descendantForm.showBack();
            }else{
                //Test Begin (Remove it when real data exists)
                List<Image> list = new ArrayList<>();
                try {
                    //for(int i=0;i<3;i++)list.add(Image.createImage("/img.png").scaled(75,75));
                    int width = 150;
                    Image houses = Image.createImage("/4houses.jpg").scaled(2*width,2*width);
                    Image roundMask = Image.createImage(width, width, 0xff000000);
                    Graphics gr = roundMask.getGraphics();
                    gr.setColor(0xffffff);
                    gr.fillArc(0, 0, width, width, 0, 360);
                    Object mask = roundMask.createMask();
                    list.add(houses.subImage(0, 0, width, width, false).applyMask(mask));
                    list.add(houses.subImage(houses.getWidth()/2, 0, width, width, false).applyMask(mask));
                    list.add(houses.subImage(0, houses.getHeight()/2, width, width, false).applyMask(mask));
                    descendantForm = new Home(parentForm,null,"Jon Snow da Silva",100,Image.createImage("/jonsnow.jpg"),list);
                    ((TemplateForm)descendantForm).setHomeForm(descendantForm);
                } catch (IOException ex) {
                }
                //Test End
            }
        }
    }
    boolean isValidUser(){
        //Validate user information
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import br.edu.unifei.eco.tfg.gamification.view.Home;
import com.codename1.ui.Form;
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
                    for(int i=0;i<3;i++)list.add(Image.createImage("/img.png").scaled(75,75));
                    descendantForm = new Home(parentForm,"Wu Liang Kuan",100,Image.createImage("/4houses.jpg"),list);
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

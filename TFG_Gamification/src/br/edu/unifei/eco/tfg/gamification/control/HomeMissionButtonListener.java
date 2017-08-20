/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import br.edu.unifei.eco.tfg.gamification.view.Home;
import br.edu.unifei.eco.tfg.gamification.view.Mission;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HomeMissionButtonListener implements ActionListener{
    private Form parentForm = null;
    private Form descendantForm = null;
    public HomeMissionButtonListener(Form hi){
        parentForm = hi;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        String text = e.getSource().toString();
//        Log.p("Event source: "+text+" > Handled by HomeMissionButtonListener");
        if(descendantForm != null){
            descendantForm.showBack();
        }else{
            //Test Begin (Remove it when real data exists)
            List<String> list = new ArrayList<>();
            for(int i=0;i<5;i++)list.add("Mission "+(i+1));
            descendantForm = new Mission(parentForm,list,list,list,list);
            //Test End
        }
    }
}

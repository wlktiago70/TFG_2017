/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import com.codename1.components.MultiButton;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author User
 */
public class SearchButtonListener implements ActionListener{
    private Form hi;
    public SearchButtonListener(Form hi){
        this.hi = hi;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = (String)e.getSource();
        if(text == null || text.length() == 0) {
            // clear search
            for(Component cmp : hi.getContentPane()) {
                cmp.setHidden(false);
                cmp.setVisible(true);
            }
            hi.getContentPane().animateLayout(150);
        } else {
            text = text.toLowerCase();
//            for(Component cmp : hi.getContentPane()) {
//                MultiButton mb = (MultiButton)cmp;
//                String line1 = mb.getTextLine1();
//                String line2 = mb.getTextLine2();
//                boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1 ||
//                        line2 != null && line2.toLowerCase().indexOf(text) > -1;
//                mb.setHidden(!show);
//                mb.setVisible(show);
//            }
            hi.getContentPane().animateLayout(150);
        }
    }   
    
}

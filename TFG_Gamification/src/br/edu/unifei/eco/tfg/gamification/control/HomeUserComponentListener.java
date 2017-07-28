/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author User
 */
public class HomeUserComponentListener implements ActionListener{
    private Form hi;
    public HomeUserComponentListener(Form hi){
        this.hi = hi;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getSource().toString();
        Log.p("Event source: "+text+" > Handled by HomeUserComponentListener");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import br.edu.unifei.eco.tfg.gamification.view.MissionCreate;
import br.edu.unifei.eco.tfg.gamification.view.TemplateForm;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author wkuan
 */
public class MissionCreateButtonListener implements ActionListener{
    private Form parentForm = null;
    private Form descendantForm = null;
    public MissionCreateButtonListener(Form hi){
        parentForm = hi;
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        descendantForm = new MissionCreate((TemplateForm) parentForm);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.control.SearchButtonListener;
import com.codename1.io.Log;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;

/**
 *
 * @author wkuan
 */
public abstract class TemplateForm extends Form{
    protected Form parentForm = null;
    protected Form logoutForm = null;
    protected Form homeForm = null;
    
    public TemplateForm(Form parent,Form home,String title,Layout layout){
        super(title,layout);
        parentForm = parent;
        try{
            logoutForm = ((TemplateForm)parentForm).getLogoutForm();
        }catch(Exception e){
            logoutForm = parentForm;
        }
        homeForm = home;
        configureToolbar();
    }
    public TemplateForm(Form parent,Form home,String title){
        super(title);
        parentForm = parent;
        try{
            logoutForm = ((TemplateForm)parentForm).getLogoutForm();
        }catch(Exception e){
            logoutForm = parentForm;
        }
        homeForm = home;
        configureToolbar();
    }
    
    public Form getHomeForm() {
        return homeForm;
    }
    
    public Form getParentForm() {
        return parentForm;
    }

    public Form getLogoutForm() {
        return logoutForm;
    }
    
    public void setHomeForm(Form form) {
        homeForm = form;
    }
    
    public void setParentForm(Form form) {
        parentForm = form;
    }

    public void setLogoutForm(Form form) {
        logoutForm = form;
    }
    
    private void configureToolbar(){
        Toolbar.setGlobalToolbar(true);
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        this.getToolbar().addCommandToLeftBar("", FontImage.createMaterial(FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, s), (e) -> parentForm.showBack());
        this.getToolbar().addCommandToSideMenu("Home", null, (e) -> homeForm.showBack());
        this.getToolbar().addCommandToSideMenu("Logout", null, (e) -> logoutForm.showBack());
        this.getToolbar().addSearchCommand(new SearchButtonListener(this), 3);
        this.getToolbar().addCommandToRightBar("", FontImage.createMaterial(FontImage.MATERIAL_MORE_VERT, s), (e) -> Log.p("Clicked"));
        //this.getToolbar().addCommandToOverflowMenu("Overflow", null, (e) -> Log.p("Clicked"));
    }
}

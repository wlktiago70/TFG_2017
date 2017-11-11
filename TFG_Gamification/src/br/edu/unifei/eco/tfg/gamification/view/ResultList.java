/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import com.codename1.components.MultiButton;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author wkuan
 */
public class ResultList extends TemplateForm{
    private List<MultiButton> resultSet = new ArrayList<>();
    private Map<String,String> map;
    private boolean checkBox  = false;
    public ResultList(Form parent,Form home,Map<String,String> mapList){
        super(parent,home,"Result",new BoxLayout(BoxLayout.Y_AXIS));
        map = mapList;
        for(String str: map.keySet()){
            resultSet.add(new MultiButton(str));
        }
        uploadContent();
    }
    public ResultList(Form parent,Form home,Map<String,String> mapList,boolean checkBox){
        super(parent,home,"Result",new BoxLayout(BoxLayout.Y_AXIS));
        map = mapList;
        for(String str: map.keySet()){
            resultSet.add(new MultiButton(str));
        }
        uploadContent();
    }
    private void uploadContent(){
        this.removeAll();
        for(MultiButton bnt: resultSet){
            bnt.setCheckBox(checkBox);
            this.add(bnt);
        }
        this.repaint();
    }
}

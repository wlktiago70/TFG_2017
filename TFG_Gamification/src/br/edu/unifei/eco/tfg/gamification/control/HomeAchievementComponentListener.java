/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.control;

import br.edu.unifei.eco.tfg.gamification.view.Home;
import br.edu.unifei.eco.tfg.gamification.view.HomeUserProfile;
import br.edu.unifei.eco.tfg.gamification.view.charts.BudgetDoughnutChart;
import com.codename1.charts.util.ColorUtil;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HomeAchievementComponentListener implements ActionListener{
    private Form parent;
    private Form descendant = null;
    public HomeAchievementComponentListener(Form parent){
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = e.getSource().toString();
        Log.p("Event source: "+text+" > Handled by HomeAchievementComponentListener");
        if(descendant == null){
            List<double[]> values = new ArrayList<double[]>();
            values.add(new double[] { 10, 9, 14, 20, 11 });
            values.add(new double[] { 12, 14, 11, 10, 19 });
            values.add(new double[] { 10, 9, 14 });
            List<String[]> titles = new ArrayList<String[]>();
            titles.add(new String[] { "Volunteering", "Instructional", "Athletics", "Cutural", "Others" });
            titles.add(new String[] { "P1", "P2", "P3", "P4", "P5" });
            titles.add(new String[] { "Achievement 1", "Achievement 2", "Achievement 3"});
            int[] colors = new int[] { ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
            descendant = new HomeUserProfile(parent,parent,((Home)parent).getUserName(),((Home)parent).getUserScore(),"Social Engineer","Stark","User profile",values,titles,colors);
        }else descendant.showBack();
        
    }
}

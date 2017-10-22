/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.view;

import br.edu.unifei.eco.tfg.gamification.view.charts.BudgetDoughnutChart;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.TableLayout;
import java.util.List;

/**
 *
 * @author wkuan
 */
public class HomeUserProfile extends TemplateForm{
    private List<double[]> values;
    private List<String[]> titles;
    private int[] colors;
    private TableLayout tabLyt = new TableLayout(2,1);
    private Label lblUserOccupation;
    private Label lblUserHouse;
    private Label lblUserName;
    private Label lblUserScore;
    private Button btnFriends = new Button("Friends");
    private Container cntCenter = new Container(tabLyt);
    public HomeUserProfile(Form parent, Form home, String name, int score, String occupation, String house, String title, List<double[]> values, List<String[]> titles, int[] colors) {
        super(parent, home, title, new BorderLayout());
        this.values = values;
        this.titles = titles;
        this.colors = colors;        
        lblUserName = new Label(name);
        lblUserScore = new Label(Integer.toString(score));
        lblUserOccupation = new Label(occupation);
        lblUserHouse = new Label(house);
        cntCenter.add(tabLyt.createConstraint().heightPercentage(30),TableLayout.encloseIn(2, new Label("Name: "),lblUserName,
                                                                                              new Label("Score: "),lblUserScore,
                                                                                              new Label("Occupation: "),lblUserOccupation,
                                                                                              new Label("House: "),lblUserHouse))
                 .add(tabLyt.createConstraint().heightPercentage(90),(new BudgetDoughnutChart()).getChart(this.values,this.titles,this.colors));
        this.add(BorderLayout.CENTER,cntCenter);
        this.add(BorderLayout.SOUTH,btnFriends);
        this.show();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class ManualValidation extends Goal {
    private List<Player> sensors = new ArrayList<Player>();     //jogadores que podem validar a quest

    public ManualValidation(String description, Quest quest) {
        super(description, quest);
    }
  
        
    public void addSensors(Player sensor){
        this.sensors.add(sensor);
        sensor.addSensoringGoals(this);
    }
    
    @Override
    public void validate(Request rq){
        rq.getMaker().getQuestGoals().get(
                rq.getMaker().getQuestGoals().indexOf(
                        rq.getQuest().getGoals())).get(
                                rq.getQuest().getGoals().indexOf(rq.getGoal())).setFinished(true);
        
        removeRequests(rq);
        
    }    
}

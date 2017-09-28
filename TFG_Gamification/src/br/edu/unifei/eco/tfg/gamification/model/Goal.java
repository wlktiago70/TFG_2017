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
public abstract class Goal {
    
    private String description;         //descricao do objetivo
    private boolean finished;           //indica se a meta foi cumprida
    private List<Request> requests = new ArrayList<Request>();  //Requisiçoes para validar a goal
    private final Quest quest;
    
    
    public Goal(String description, Quest quest) {
        this.description = description;
        this.finished = false;
        this.quest = quest;
    }
       

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void removeRequests(Request requests) {
        this.requests.remove(requests);
    }

    public Quest getQuest() {
        return quest;
    }
    
    
    //solicita a validaçao da Goal
    public boolean makeRequest(Player player){
        Request rq = new Request(player,this.quest,this);
        this.requests.add(rq);
        return true;
    }
    
    public void validate(Request rq){
        
    }
    
    
    
}

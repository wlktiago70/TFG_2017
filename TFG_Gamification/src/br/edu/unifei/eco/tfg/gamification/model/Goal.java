/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
@DatabaseTable(tableName = "Goal")
public abstract class Goal {
    @DatabaseField()
    private String description;         //descricao do objetivo
    @DatabaseField()
    private boolean finished;           //indica se a meta foi cumprida
    @DatabaseField()
    private List<Request> requests = new ArrayList<Request>();  //Requisiçoes para validar a goal
    @DatabaseField()
    private final Quest quest;
    @DatabaseField()
    private List<Player> finishedPlayers;
    
    
    public Goal(String description, Quest quest) {
        this.description = description;
        this.finished = false;
        this.quest = quest;
        this.finishedPlayers = new ArrayList<>();
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

    public List<Player> getFinishedPlayers() {
        return finishedPlayers;
    }
    
    public void addFinishedPlayers(Player player) {
        this.finishedPlayers.add(player);
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

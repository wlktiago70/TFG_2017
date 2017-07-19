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
public abstract class Quest {
    
    private String name;                                            //nome da quest
    private String description;                                     //descriçao geral da quest
    private boolean finished;                                       //status da quest        
    private int visibility;                                         //visibilidade da quest (depende do numero de jogadores e da reputacao do criador nas SQ - sempre max nas MQ) 
    private List<Player> usersEnlisted = new ArrayList<Player>();   //lista de usuario que participam da missao    
    
    private List<Goal> goals= new ArrayList<Goal>();            //lista de metas para a missao
    private List<Reward> rewards= new ArrayList<Reward>();      //lista de recompensa para a missao

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public List<Player> getUsersEnlisted() {
        return usersEnlisted;
    }

    public void setUsersEnlisted(List<Player> usersEnlisted) {
        this.usersEnlisted = usersEnlisted;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
    
    
    
    //calcula a recompesa que o player ira receber, com base nas metas que ele completou
    Reward calculateRewards (){
        
    }
    //calcula a visibilidade que a quest possui
    int calculateVisibility (){
        
    }
    
    
    
}

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
    private List<Player> usersEnlisted = new ArrayList<Player>();   //lista de usuario que participam da missao    
    private List<Goal> goals = new ArrayList<Goal>();            //lista de metas para a missao
    private List<Reward> rewards = new ArrayList<Reward>();      //lista de recompensa para a missao

    
    public Quest(String name, String description, List<Goal> goals, List<Reward> rewards) {
        this.name = name;
        this.description = description;
        this.goals = goals;
        this.rewards = rewards;
        
        this.finished = false;
    }
    
        
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

    public List<Player> getUsersEnlisted() {
        return usersEnlisted;
    }
    /*
    public void setUsersEnlisted(List<Player> usersEnlisted) {
        this.usersEnlisted = usersEnlisted;
    }
    */
    public List<Goal> addUsersEnlisted(Player player) {
        this.usersEnlisted.add(player);
        return this.goals;
    }
    
    public void removeUsersEnlisted(Player player) {
        this.usersEnlisted.remove(player);
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
    /*
    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }
    */
    //verifica se as goals estao completas e altera o estado da quest
    public boolean isCompleted(List<Goal> playerGoals) {
        for (Goal g : playerGoals) {
            if (!g.isFinished()) return false;
        }
                       
        return true;
    }
    
    //calcula a recompesa que o player ira receber, com base nas metas que ele completou
    public List<Reward> calculateRewards (){
        List<Reward> parcRewards = new ArrayList<>() ;
        //calcula as rewards com base em isCompleted
        
        return parcRewards;
    }
    
    public void giveReward(Player player){
        player.receiveReward(calculateRewards());
    }
    
    //termina a quest distribuindo as recompensas e removendo os jogadores
    public void finishQuest(){
        this.finished = true;
        for (Player player : usersEnlisted) {
            giveReward(player);
            usersEnlisted.remove(player);
        }
        
    }
    
    
    
}

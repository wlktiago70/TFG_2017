/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import java.util.List;

/**
 *
 * @author Paulo
 */
public enum PrivilegeEnum {

    beginer(1,1,750,0,0,0,0),
    experienced(3,2,2000,2,2,3,10),
    master(5,3,-1,5,5,5,25),
    creator(0,0,-1,-1,7,7,25);
    
    //privilegios relacionados ao jogo
    private final int maxSQJoined;                    //numero maximo de SQ ativas ao mesmo tempo
    private final int maxPartyJoined;                 //numero maximo de partys que o jogador pode estar  
    private final float nextPrivilege;                //quantidade de xp para poder passar para o prox privilegio
    
    //privelegios relacionados a criaçao de side quests
    private final int maxSQCreated;                   //numero maximo de SQ criadas ativas ao mesmo tempo
    private final int maxGoals;                       //numero maximo de goals por SQ criada    
    private final int maxRewardsGiven;                //numero maximo de recompensas por SQ criada 
        
    //privilegios relacionados a criacao de grupos
    private final int maxNumberPlayers;               //numero maximo de players na party

    
    private PrivilegeEnum(int maxSQJoined, int maxPartyJoined, float nextPrivilege, int maxSQCreated, int maxGoals,
                                            int maxRewardsGiven, int maxNumberPlayers) {
        this.maxSQJoined = maxSQJoined;
        this.maxPartyJoined = maxPartyJoined;
        this.nextPrivilege = nextPrivilege;
        this.maxSQCreated = maxSQCreated;
        this.maxGoals = maxGoals;
        this.maxRewardsGiven = maxRewardsGiven;
        this.maxNumberPlayers = maxNumberPlayers;
    }
       
    
    

    public int getMaxSQJoined() {
        return maxSQJoined;
    }

    public int getMaxPartyJoined() {
        return maxPartyJoined;
    }

    public float getNextPrivilege() {
        return nextPrivilege;
    }

    public int getMaxSQCreated() {
        return maxSQCreated;
    }

    public int getMaxGoals() {
        return maxGoals;
    }

    public int getMaxRewardsGiven() {
        return maxRewardsGiven;
    }
    
    public int getMaxNumberPlayers() {
        return maxNumberPlayers;
    }
    
    
}

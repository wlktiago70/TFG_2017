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
public class Game {
    private List<Player> players;
    private List<MainQuest> mainQuests;
    private List<SideQuest> sideQuests;
    private List<Clan> clans;
    private List<Party> partys;

    public Game() {
        this.players = new ArrayList<Player>();
        this.mainQuests = new ArrayList<MainQuest>();
        this.sideQuests = new ArrayList<SideQuest>();
        this.clans = new ArrayList<Clan>();
        this.partys = new ArrayList<Party>();
    }
    
       
    public void newPlayer(Player player){
        this.players.add(player);
    }
    
    public void newQuest(SideQuest sq){
        this.sideQuests.add(sq);
    }
    
    public void newParty(Party party){
        this.partys.add(party);
    }
    
    public void initMainquests(){
        
    }
    
    public void initClans(){
        
    }
    
    public static void main(String[] args) {
        
        new Game();
    
    
    }
    
}

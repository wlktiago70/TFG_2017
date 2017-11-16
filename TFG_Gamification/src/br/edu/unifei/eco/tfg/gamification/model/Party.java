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
@DatabaseTable(tableName = "party")
public class Party extends Group {
    @DatabaseField()
    private Player creator;                                     //criador da equipe
    @DatabaseField()
    private SideQuest sideQuest;                               //SQ que a equipe esta participando
    @DatabaseField()
    private List<Player> members = new ArrayList<Player>();
    @DatabaseField()
    private List<Player> requests;
    @DatabaseField()
    private List<Player> invites;
    @DatabaseField()
    private boolean active;

    public Party(String name, String description, Player creator, SideQuest sideQuest) {
        
        super(name, description);
        
        this.creator = creator;
        this.sideQuest = sideQuest;
        this.members.add(creator);
        this.requests = new ArrayList<>();
        this.invites = new ArrayList<>();
        this.active = true;
    }

    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    public SideQuest getSideQuest() {
        return sideQuest;
    }

    public void setSideQuest(SideQuest sideQuest) {
        this.sideQuest = sideQuest;
    }

    public List<Player> getMembers() {
        return members;
    }
    
    public List<Player> getRequests() {
        return requests;
    }

    public void setRequests(List<Player> requests) {
        this.requests = requests;
    }

    public List<Player> getInvites() {
        return invites;
    }
    
/*
    public void setInvites(List<Player> invites) {
    this.invites = invites;
    }
     */
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    //adiciona membro na equipe
    public boolean addMember(Player newMember) {
        if (this.members.size() < creator.getPrivileges().getMaxNumberPlayers() ){
            this.requests.remove(newMember);
            if(newMember.updateParty(this)){
                this.members.add(newMember);
                return true;
            }
            
        }
        return false;
    }
    
    //abandona a equipe  
    public void leaveParty(Player player){
        this.members.remove(player);
    }
    
    //adiciona um jogador na lista de solicitaçoes
    public boolean addRequest(Player player){
        
        if(!this.requests.contains(player) )
            return this.requests.add(player);
        else 
            return false;
        
    }
    
    //adiciona jogador a lista de invites
    public void invite(Player player){
        
        this.invites.add(player);
        
    }
    
        
    
}

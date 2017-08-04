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
public class Player {
    
    private String name;                                                    //nome do usuario
    private int level;                                                      //lvl do player
    private float experience;                                               //quantidade de xp que o usuario possui
    private float reputation;                                               //reputaçao que usuario adiquiriu ao criar SQ e Party
    private List<Reward> rewardsOwned;                                      //lista de recompensas conseguidas em Quests, menos exp(valor total adicionado em experience)
    private List<Reward> rewardsAvailable;                                  //lista de recompensas desbloquadas para oferecer na SQ (incluindo quantidade fixa de xp - )
    private PlayerPerformance performance;                                  //a performance geral do jogador
    private List<Player> friends = new ArrayList<Player>();                 //lista de amigos
    private List<Quest> questsJoined = new ArrayList<Quest>();              //quests ativas para o usuario(num max definido pelos privilegios)
    private List<SideQuest> createdSQ = new ArrayList<SideQuest>();         //as quests que o player criou
    private List<Party> createdPaties = new ArrayList<Party>();             //as partys que o player criou
    private List<Party> parties = new ArrayList<Party>();                   //lista de equipes que o jogador participa
    
    private Clan clan;                                                              //clan do jogador
    private PrivilegeEnum privileges;                                               //privilegios do jogador no jogo
    private List<AchievementEnum> achievements = new ArrayList<AchievementEnum>();  //conquistas que o jogador obteve
    

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public float getReputation() {
        return reputation;
    }

    public void setReputation(float reputation) {
        this.reputation = reputation;
    }

    public PlayerPerformance getPerformance() {
        return performance;
    }

    public void setPerformance(PlayerPerformance performance) {
        this.performance = performance;
    }

    public List<Reward> getRewardsOwned() {
        return rewardsOwned;
    }

    public void setRewardsOwned(List<Reward> rewardsOwned) {
        this.rewardsOwned = rewardsOwned;
    }
    
    public List<Reward> getRewardsAvailable() {
        return rewardsAvailable;
    }

    public void setRewardsAvailable(List<Reward> rewardsAvailable) {
        this.rewardsAvailable = rewardsAvailable;
    }
        
    public List<Player> getFriends() {
        return friends;
    }

    public void setFriends(List<Player> friends) {
        this.friends = friends;
    }

    public List<Quest> getQuestsJoined() {
        return questsJoined;
    }
    /*
    public void setQuestsJoined(List<Quest> questsJoined) {
        this.questsJoined = questsJoined;
    }
    */
    public void addQuestsJoined(Quest quest) {
        this.questsJoined.add(quest) ;
        quest.addUsersEnlisted(this); 
    }
    
    public void removeQuestsJoined(Quest quest) {
        this.questsJoined.remove(quest) ;
        quest.removeUsersEnlisted(this); 
    }
    
    public List<SideQuest> getCreatedSQ() {
        return createdSQ;
    }
    /*
    public void setCreatedSQ(List<SideQuest> createdSQ) {
        this.createdSQ = createdSQ;
    }
    */
    public void addCreatedSQ(SideQuest sq) {
        this.createdSQ.add(sq) ;
    }
    
    public void removeCreatedSQ(SideQuest sq) {
        this.createdSQ.remove(sq) ;
    }
    
    public List<Party> getCreatedPaties() {
        return createdPaties;
    }

    public void setCreatedPaties(List<Party> createdPaties) {
        this.createdPaties = createdPaties;
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public PrivilegeEnum getPrivileges() {
        return privileges;
    }

    public void setPrivileges(PrivilegeEnum privileges) {
        this.privileges = privileges;
    }
    
    public List<AchievementEnum> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<AchievementEnum> achievements) {
        this.achievements = achievements;
    }
    
    //atualiza o privilegio do jogador
    public void updatePrivileges(){
        
        if (this.experience >= this.privileges.getNextPrivilege()){
            switch (privileges){
                case beginer:
                    this.privileges = PrivilegeEnum.experienced;
                    break;
                case experienced:
                    this.privileges = PrivilegeEnum.master;
                    break;
            }
        }
    }
    
    public boolean createSideQuest(){
        
        updatePrivileges();
        //verificar as SQ criadas ativas - ou fazer elas se removerem da lista quando terminadas
        
        //criar a sq de acordo com as variaveis limitantes de criacao
        return true;
        
    }
    

}

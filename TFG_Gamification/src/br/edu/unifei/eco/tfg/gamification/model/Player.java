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
    private List<List<Goal>> questGoals;                                    //Todas as metas que o jogador tem a cumprir
    private List<Reward> rewardsOwned;                                      //lista de recompensas conseguidas em Quests, menos exp(valor total adicionado em experience)
    private List<Reward> rewardsAvailable;                                  //lista de recompensas desbloquadas para oferecer na SQ (incluindo quantidade fixa de xp - )
    private PlayerPerformance performance;                                  //a performance geral do jogador
    private List<Goal> sensoringGoals;                                      //Objetivos que o jogador pode validar
    private List<Player> friends = new ArrayList<Player>();                 //lista de amigos
    private List<Quest> questsJoined = new ArrayList<Quest>();              //quests ativas para o usuario(num max definido pelos privilegios)
    private List<SideQuest> createdSQ = new ArrayList<SideQuest>();         //as quests que o player criou
    private List<Party> createdPaties = new ArrayList<Party>();             //as partys que o player criou
    private Party party;                                                    //equipe que o jogador participa
    
    
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

    public List<List<Goal>> getQuestGoals() {
        return questGoals;
    }
    /*
    public void setQuestGoals(List<List<Goal>> questGoals) {
        this.questGoals = questGoals;
    }
    */
  
    public PlayerPerformance getPerformance() {
        return performance;
    }

    public void setPerformance(PlayerPerformance performance) {
        this.performance = performance;
    }

    public List<Goal> getSensoringGoals() {
        return sensoringGoals;
    }

    public void addSensoringGoals(Goal goal) {
        this.sensoringGoals.add(goal);
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
           
    public List<SideQuest> getCreatedSQ() {
        return createdSQ;
    }
    /*
    public void setCreatedSQ(List<SideQuest> createdSQ) {
        this.createdSQ = createdSQ;
    }
    */
    
    public void removeCreatedSQ(SideQuest sq) {
        this.createdSQ.remove(sq) ;
    }
    
    public List<Party> getCreatedPaties() {
        return createdPaties;
    }

    public void setCreatedPaties(List<Party> createdPaties) {
        this.createdPaties = createdPaties;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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
    
    public void enlist(Quest quest) {
        this.questsJoined.add(quest) ;
        questGoals.add(quest.addUsersEnlisted(this)); 
    }
    
    public void unlist(Quest quest) {
        this.questsJoined.remove(quest) ;
        questGoals.remove(quest.removeUsersEnlisted(this)); 
    }
    
    //atualiza o privilegio do jogador
    public void updatePrivileges(){
        
        if (this.experience >= this.privileges.getNextPrivilege()){
            switch (privileges){
                case beginer:
                    this.privileges = PrivilegeEnum.experienced;
                    return;
                case experienced:
                    this.privileges = PrivilegeEnum.master;
            }
        }
    }
    
    //verifica as SQ terminadas e retira da lista
    public void updateSQ(){
        createdSQ.stream().filter((sq) -> (sq.isFinished())).forEach((sq) -> {
            createdSQ.remove(sq);
        });
    }
    
    //cria SQ
    public SideQuest createSideQuest(String name, String description, List<Goal> goals, List<Reward> rewards){
        SideQuest newSQ;
        
        updatePrivileges();
        updateSQ();
        if(createdSQ.size() < privileges.getMaxSQCreated()){       
            newSQ = new SideQuest(this, name, description, goals, rewards);
            createdSQ.add(newSQ);
            //fazer com que SQ se removerem da lista quando terminadas
            return newSQ;
        }
        else return null;    
    }
    
    //requisita o fim da quest para receber as rewards
    public void requestReward(Quest quest){
        quest.giveReward(this);
    }
    
    //distribui a xp a adiciona as reward owned
    public void receiveReward(List<Reward> rewards){
        for (Reward reward : rewards) {
            if (!this.rewardsOwned.contains(reward))
                this.rewardsOwned.add(reward);
        }
        
    }
    
    //atualiza a equipe se nao estiver em nenhuma ainda
    public boolean updateParty(Party party){
        if (this.party == null){
            this.party = party;
            return true;
        }
        return false;
    }
    
    //cria equipe
    public Party createParty(String name, String description, SideQuest sideQuest){
        Party newPrt;
        
        newPrt = new Party(name, description, this, sideQuest);
        party = newPrt;
        
        return newPrt;
    }
    
    //jogador solicita ser adicionado na equipe
    public boolean requestParty(Party party){
        if(this.party != null) 
            this.party.leaveParty(this);
        this.party = null;
        
        if (party.addRequest(this))
            return true;
        else
            return false;
        
    }
    
    //criador da equipe aceita a solicitaçao para entrar na equipe
    public void acceptPartyRequest(List<Player> players){
       if( this.party.getCreator().equals(this) ){
           
           if(party.getRequests().containsAll(players))
               for (Player player : players) {
                   this.party.addMember(player);
                }
                      
       }
    }
    
    //jogador aceita o convite para uma equipe
    public boolean acceptPartyInvite(Party party){
        if(party.getInvites().contains(this)){
            return party.addMember(this);
        }
        return false;
    }
    
    //abandona a equipe
    public void leaveParty(){
        if (this.party !=null)
            this.party.leaveParty(this);
        this.party = null;
    }

}

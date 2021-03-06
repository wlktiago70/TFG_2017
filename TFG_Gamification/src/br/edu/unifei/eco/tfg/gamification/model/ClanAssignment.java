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
@DatabaseTable(tableName = "clanAssigment")
public class ClanAssignment {
    @DatabaseField(foreign = true)
    private List<Clan> clans;
    @DatabaseField(foreign = true)
    private Player player;
    @DatabaseField()
    private List<Question> questions;
    @DatabaseField()
    private int scores[];
   

    public ClanAssignment(List<Clan> clans, Player player, List<Question> questions) {
        this.clans = clans;
        this.player = player;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
    
    public void calculateScores(){

        for (Question question: questions) {
            for (int i = 0; i < scores.length; i++) {
                scores[i] += question.getScores()[i];
            }
            
        }
              
    }
    
    public boolean assignPlayer(){
        for (Question question: questions) {
            if(!question.isAnswered()) return false;
        }
        calculateScores();
        
        int aux = 0;
        for (int i = 1; i < scores.length; i++) {
            if(scores[aux] <= scores[i]) aux = i;
            
        }
                
        this.player.setClan(clans.get(aux));
        this.clans.get(aux).addMember(player);
        return true;
        
    }
    
    
    
}

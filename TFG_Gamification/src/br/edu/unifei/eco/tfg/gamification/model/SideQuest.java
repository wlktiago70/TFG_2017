/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.List;

/**
 *
 * @author Paulo
 */
@DatabaseTable(tableName = "sideQuest")
public class SideQuest extends Quest {
    
    @DatabaseField()
    private Player creator;             //criador da SQ
    @DatabaseField()
    private Party participatingPartys;  //partys que estao participando da SQ
    @DatabaseField()
    private ClassificationEnum classification;   //classificaçao quanto ao tipo da SQ

    
    public SideQuest(Player creator, String name, String description, List<Reward> rewards, ClassificationEnum classification) {
        
        super(name, description, rewards);
        this.creator = creator;
        this.classification = classification;
        
    }
    
    
    public Player getCreator() {
        return creator;
    }
    
    /*
    public void setCreator(Player creator) {
        this.creator = creator;
    }
    */
    
    public Party getParticipatingPartys() {
        return participatingPartys;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }
        
    public void setParticipatingPartys(Party participatingPartys) {
        this.participatingPartys = participatingPartys;
    }
    
    
}

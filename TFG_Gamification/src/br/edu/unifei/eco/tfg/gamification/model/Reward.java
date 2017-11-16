/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author Paulo
 */
@DatabaseTable(tableName = "reward")
public abstract class Reward {
    
    @DatabaseField()
    private String description;        //descriçao da recompensa
    @DatabaseField()
    private int rarity;                //raridade da recompensa 0=comum,1=incomum,2=rara



    public Reward(String description, int rarity) {
        this.description = description;
        this.rarity = rarity;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     
    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }
    
    
    
}

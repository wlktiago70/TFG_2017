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
@DatabaseTable(tableName = "medal")
public class Medal extends Reward{
    @DatabaseField()
    private final String name;         //nome especifico do item

    public Medal(String name, String description, int rarity) {
        super(description, rarity);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    
}

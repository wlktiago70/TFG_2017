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

@DatabaseTable(tableName = "mainQuest")
public class MainQuest extends Quest {
    @DatabaseField()
    private int chapter;        //capitulo da mainquest 
    
    public MainQuest(int chapter, String name, String description, List<Reward> rewards) {
      
        super(name, description, rewards);
        this.chapter = chapter;
      
    }

    public int getChapter() {
        return chapter;
    }
    
    
    
}

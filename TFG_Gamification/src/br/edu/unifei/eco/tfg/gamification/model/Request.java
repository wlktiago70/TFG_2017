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
@DatabaseTable(tableName = "request")
public class Request {
    @DatabaseField()
    private Player maker;
    @DatabaseField()
    private Quest quest;
    @DatabaseField()
    private Goal goal;

    public Request(Player maker, Quest quest, Goal goal) {
        this.maker = maker;
        this.quest = quest;
        this.goal = goal;
    }

    public Player getMaker() {
        return maker;
    }

     public Quest getQuest() {
        return quest;
    }

    public Goal getGoal() {
        return goal;
    }
    
}

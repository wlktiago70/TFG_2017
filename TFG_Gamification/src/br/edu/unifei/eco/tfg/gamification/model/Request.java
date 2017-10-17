/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unifei.eco.tfg.gamification.model;

/**
 *
 * @author Paulo
 */
public class Request {
    private Player maker;
    private Quest quest;
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

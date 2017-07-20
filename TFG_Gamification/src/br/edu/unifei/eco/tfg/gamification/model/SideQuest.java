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
public class SideQuest extends Quest {
    
    private Player creator;             //criador da SQ
    private Party participatingPartys;  //partys que estao participando da SQ

    public Player getCreator() {
        return creator;
    }

    public void setCreator(Player creator) {
        this.creator = creator;
    }

    public Party getParticipatingPartys() {
        return participatingPartys;
    }

    public void setParticipatingPartys(Party participatingPartys) {
        this.participatingPartys = participatingPartys;
    }
    
    
}

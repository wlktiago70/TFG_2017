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
public class Experience extends Reward{
    
    private final double amount;

    public Experience(double amount) {
        super("Recompensa padrão de missões", 0);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
    
    
}

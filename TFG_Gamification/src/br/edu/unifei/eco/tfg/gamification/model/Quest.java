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
public abstract class Quest {
    
    private String name;                                        //nome da quest
    private boolean finished;                                   //status da quest        
    private int visibility;                                     //visibilidade da quest (depende do numero de jogadores e da reputacao do criador nas SQ - sempre max nas MQ) 
        
    private List<Goal> goals= new ArrayList<Goal>();            //lista de metas para a missao
    private List<Reward> rewards= new ArrayList<Reward>();      //lista de recompensa para a missao
    
    
    //calcula a recompesa que o player ira receber, com base nas metas que ele completou
    Reward calculateRewards (){
        
    }
    //calcula a visibilidade que a quest possui
    int calculateVisibility (){
        
    }
    
    
    
}

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

@DatabaseTable(tableName = "game")
public class Game {
    @DatabaseField(foreign = true)
    private List<Player> players;
    @DatabaseField(foreign = true)  
    private List<MainQuest> mainQuests;
    @DatabaseField(foreign = true)  
    private List<SideQuest> sideQuests;
    @DatabaseField(foreign = true)
    private List<Clan> clans;
    @DatabaseField(foreign = true)
    private List<Party> partys;
    @DatabaseField(foreign = true)
    private List<Question> assignmentQuestions;

    public Game() {
        this.players = new ArrayList<Player>();
        this.mainQuests = new ArrayList<MainQuest>();
        this.sideQuests = new ArrayList<SideQuest>();
        this.clans = new ArrayList<Clan>();
        this.partys = new ArrayList<Party>();
        this.assignmentQuestions = new ArrayList<>();
        
        //inicia as  main quests
        List<Reward> rw = new ArrayList<Reward>();
        Reward xp = new Experience(500);
        rw.add(xp);
        
        MainQuest mq = new MainQuest(1, "MainQuest1", "Main Quest Test", rw);
        
        Goal g = new ManualValidation("Goal Teste", mq);
        List<Goal> goals = new ArrayList<Goal>();
        goals.add(g);
        
        mq.setGoals(goals);
        
        this.mainQuests.add(mq);
        
        
        //inicia os clans
        Clan c1,c2,c3,c4;
        
        c1 = new Clan("Clan1", "Clan Teste 1");
        this.clans.add(c1);
        
        c2 = new Clan("Clan2", "Clan Teste 2");
        this.clans.add(c2);
        
        c3 = new Clan("Clan3", "Clan Teste 3");
        this.clans.add(c3);
        
        c4 = new Clan("Clan4", "Clan Teste 4");
        this.clans.add(c4);
        
        
        //cria 2 jogadores
        Player p1, p2, p3;
                
        p1 = new Player("player1", PlayerOcupationEnum.eComputacao);
        this.players.add(p1);
                
        p2 = new Player("player2", PlayerOcupationEnum.eControleAutomacao);
        this.players.add(p2);
        
        p3 = new Player("player3", PlayerOcupationEnum.eEletronica);
        this.players.add(p3);
        
        /* falta add as quests
        //designa o clans para os players
        ClanAssignment caP1, caP2, caP3;
        caP1 = new ClanAssignment(clans, p1, assignmentQuestions);
        
        //procedimento para  ruegistrar um player em um clan
        List<Question> questions = caP1.getQuestions();
        for (Question question : questions) {
            question.answer(answer);
        }
        caP1.assignPlayer();
        
        caP2 = new ClanAssignment(clans, p2, assignmentQuestions);
        caP3 = new ClanAssignment(clans, p3, assignmentQuestions);
        */

        //player 1 cria uma sidequest (com a msm reward da mainquest para fins de simplificaçao)
        p1.setPrivileges(PrivilegeEnum.experienced);
        SideQuest sq = p1.createSideQuest("SideTst", "Side Quest test", rw, ClassificationEnum.other);
        
        Goal sqGoal = new ManualValidation("SideQuest Goal Teste", sq);
        List<Goal> sqGoals = new ArrayList<Goal>();
        sqGoals.add(sqGoal);
        
        sq.setGoals(sqGoals);
        
        this.sideQuests.add(sq);
        
        //player 2 e 3 entram na side quest
        p2.enlist(sq);
        p3.enlist(sq);
        
        
        //player 2 cria uma party para completar a side quest
        Party pt = p2.createParty("PartyTst", "Party Test", sq);
        this.partys.add(pt);
        

        //mandando os convites de grupo para player 1 e 3
        pt.invite(p1);
        pt.invite(p3);
        
        
        //player 1 e 3 aceitam o convite para party 
        p1.acceptPartyInvite(pt);
        p3.acceptPartyInvite(pt);
        
        
        //player 1(criador) add player 2 como um sensor para a goal
        if( ((ManualValidation) p1.getCreatedSQ().get(0).getGoals().get(0)) instanceof ManualValidation )
            ((ManualValidation) p1.getCreatedSQ().get(0).getGoals().get(0)).addSensors(p2);
        
        
        //player 3 faz uma requisiçao para completar a goal
        p3.getQuestGoals().get(0).get(0).makeRequest(p3);
        
        //player 2 valida a requisiçao do player 3
        Request rq = p2.getSensoringGoals().get(0).getRequests().get(0);
        p2.getSensoringGoals().get(0).validate(rq);
    }
       
    public static void main(String[] args) {
     
        new Game();
    }
    
}

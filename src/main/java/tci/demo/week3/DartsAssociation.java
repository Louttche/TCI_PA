package tci.demo.week3;

import java.util.ArrayList;
import java.util.List;

public class DartsAssociation {
    private List<Member> members;
    private List<Game> games;
    private PlayerScore currentScore = new PlayerScore(0, null, null); // maybe make it for each member

    /**
     *
     * @param players
     * @param games
     *
     * @should throw IllegalArgumentException if players is null
     * @should throw IllegalArgumentException if games is null
     */
    public DartsAssociation(List<Member> players, List<Game> games){
        this.members = players;
        this.games = games;
    }

    public void AddScoreToMember(){
        ;
    }

    public void AddGame(){
        ;
    }

    /**
     *
     * @param name
     */
    public void AddMember(String name){
        //for (Member m:this.members) {
        //    if (m.GetName() == name)
        //        return;
        //}

        this.members.add(new Member(name));
    }

    public void ChangeMemberName(String initialName, String newName){
        for (Member m:this.members) {
            if (m.GetName() == initialName)
                m.SetName(newName);
        }
    }

    public void DeleteMember(String name){
        for (Member m:this.members) {
            if (m.GetName() == name)
                this.members.remove(m);
        }
    }

    public void CreateGame(Member player1, Member player2){
        List<Member> membersToAdd = new ArrayList<>();
        membersToAdd.add(player1);
        membersToAdd.add(player2);

        this.games.add(new Game(this.games.size() + 1, membersToAdd));
    }

    public Game GetGame(Game finishedGame){
        for (Game g: this.games) {
            if (finishedGame == g)
                return g;
        }

        return null;
    }

    public Game FindGameByID(Integer id){
        for (Game g:this.games) {
            if (g.GetID() == id)
                return g;
        }
        return null;
    }

    public void AddTurnScore(Integer score){
        this.currentScore.SetScore(score);
    }

    public PlayerScore GetCurrentScore(){
        return this.currentScore;
    }
}
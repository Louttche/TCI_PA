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
        if (players == null)
            throw new IllegalArgumentException("Players can't be null");
        if (games == null)
            throw new IllegalArgumentException("Games can't be null");

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
    public void AddMember(String name) throws NonUniqueNameException {
        for (Member m:this.members) {
            if (m.GetName() == name)
                throw new NonUniqueNameException("Member already exists.");
        }

        Member m = new Member(name);
        this.members.add(m);
    }

    public void ChangeMemberName(String initialName, String newName){
        for (Member m:this.members) {
            if (m.GetName() == initialName)
                m.SetName(newName);
        }
    }

    public List<Member> GetMembers(){
        return this.members;
    }

    public void DeleteMember(String name){
        for (Member m:this.members) {
            if (m.GetName() == name)
                this.members.remove(m);
        }
    }

    public void CreateGame(Member player1, Member player2) throws IncorrectIdException {
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

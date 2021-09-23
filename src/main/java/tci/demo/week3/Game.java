package tci.demo.week3;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Game {
    private Member currentPlayer;
    private List<Member> members;
    private Member winner;
    private List<PlayerScore> playerScores;

    private Integer id;
    private final LocalDateTime dateStarted;

    /**
     *
     * @param id
     * @param players
     * @should Throw IncorrectIdException if id is invalid
     * @should Throw IllegalArgumentException if players is null
     */
    public Game(int id, List<Member> players){
        this.id = id;
        this.members = players;
        this.currentPlayer = players.get(0);
        this.winner = null;

        this.dateStarted = LocalDateTime.now();
    }

    public Member GetCurrentPlayer(){
        return this.currentPlayer;
    }

    public Member GetWinner(){
        return this.winner;
    }

    public Integer GetID(){
        return this.id;
    }

    public String GetPlayerScores(){
        String scores = "";
        for (PlayerScore ps:this.playerScores) {
            scores += " - " + ps.GetScore();
        }

        return scores.substring(3); // substring so that the first " - " gets removed
    }

    public List<Member> GetMembers(){
        return this.members;
    }

    // Returns boolean to show if game is finished
    public boolean AddPlayerScore(Integer score){
        this.playerScores.add(new PlayerScore(score, this, this.currentPlayer));

        Integer scoreSum = 0;
        for (Integer ps:this.currentPlayer.GetScores()) {
            scoreSum += ps;
        }

        // If game not finished go to next player
        if (score + scoreSum < 501){
            int index = 0;
            for (Member m:this.members) {
                if (m == this.currentPlayer){
                    if (index == this.members.size() - 1)
                        // set current player to the first member in list if at the end of list
                        this.currentPlayer = this.members.get(0);
                    else
                        // set current player to the next one in the list
                        this.currentPlayer = this.members.get(++index);
                }
                index++;
            }
        } else { // Game is finished
            return true;
        }

        return false;
    }
}

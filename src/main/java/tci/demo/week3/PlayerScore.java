package tci.demo.week3;

public class PlayerScore {
    private Member member;
    private Game game;
    private int score;

    /**
     *
     * @param score
     *
     * @should throw IllegalArgumentException if score is null
     */
    public PlayerScore(Integer score, Game game, Member player){
        this.score = score;
        this.game = game;
        this.member = player;
    }

    public Integer GetScore(){
        return this.score;
    }

    public void SetScore(Integer score){
        this.score = score;
    }

    public Member GetPlayer(){
        return this.member;
    }

    public void SetPlayer(Member player){
        this.member = player;
    }

    public Game GetGame(){
        return this.game;
    }

    public void SetGame(Game game){
        this.game = game;
    }
}

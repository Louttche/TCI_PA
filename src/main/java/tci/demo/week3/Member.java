package tci.demo.week3;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Member {
    private String name;
    private Integer numOfMembers;
    private List<Integer> scores;

    /**
     *
     * @param name
     *
     * @should throw NonUniqueNameException if adding member without unique name
     * @should throw IllegalArgumentException if name is null
     */
    public Member(String name){
        this.name = name;
    }

    public void AddScore(Integer score){
        this.scores.add(score);
    }

    public List<Integer> GetScores(){
        return this.scores;
    }

    public String GetName(){
        return this.name;
    }

    public void SetName(String name){
        this.name = name;
    }
}

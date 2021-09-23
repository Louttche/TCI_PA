package tci.demo.week3;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Member {
    //private static DartsAssociation da;
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
    public Member(String name/*, DartsAssociation da*/) throws NonUniqueNameException {
        if (name == null)
            throw new IllegalArgumentException("Name can't be null.");

        //da.AddMember(name);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return name == member.GetName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package tci.demo.week2;

import java.util.Set;

public class Chapter implements IChapter {

    private final Integer number;
    private final String name;
    private Chapter parent;
    private Set<Chapter> subchapters;

    @Override
    public String GetName() {
        return null;
    }

    @Override
    public int GetChapterNumber() {
        return 0;
    }

    @Override
    public Chapter GetParentChapter() {
        return null;
    }

    @Override
    public Set<Chapter> GetSubchapters() {
        return null;
    }

    /**
     *
     * @param number
     * @param name
     * @param parent
     *
     * @should throw IllegalArgumentException if number is null
     * @should throw IllegalArgumentException if name is null
     */
    public Chapter(Integer number, String name, Chapter parent/*, Set<Chapter> subchapters*/){
        if (number == null)
            throw new IllegalArgumentException("Number cannot be null.");
        if (name == null)
            throw new IllegalArgumentException("Name cannot be null.");

        this.number = number;
        this.name = name;
        this.parent = parent;
        this.parent.subchapters.add(this);
        //this.subchapters = subchapters;
    }
}

package tci.demo.week2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Book implements IBook {

    private String name;
    private String author;
    private List<Chapter> chapters;

    @Override
    public String GetName() {
        return this.name;
    }

    @Override
    public String GetAuthor() {
        return this.author;
    }

    @Override
    public List<Chapter> GetChapters() {
        return this.chapters;
    }

    @Override
    public Collection<String> GetTOC(Integer level) {
        Collection<String> TOC = new ArrayList<>();
        level = 0;

        for (Chapter c: this.GetChapters()) {
            String TOC_line = c.GetChapterNumber() + ". " + c.GetName();
            TOC.add(TOC_line);
            if (c.GetSubchapters().size() > 0){
                TOC.addAll(GetTOCChapters(level, c));
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @param author
     * @param chapters
     *
     * @should throw IllegalArgumentException if name is null
     * @should throw IllegalArgumentException if author is null
     */
    public Book(String name, String author, List<Chapter> chapters){
        this.name = name;
        this.author = author;
        this.chapters = chapters;
    }

    /**
     *
     * @param level
     * @param parent
     * @return
     */
    private Collection<String> GetTOCChapters(Integer level, Chapter parent){
        Collection<String> subchapters = null;
        String tab_space = "";
        for (int i = 0; i < level; i++)
            tab_space += "\t";

        for (Chapter sc:parent.GetSubchapters()) {
            String subchapter_line = tab_space + parent.GetChapterNumber() + "." + sc.GetChapterNumber() + ". " + sc.GetName();
            subchapters.add(subchapter_line);

            if (sc.GetSubchapters().size() > 0){
                GetTOCChapters(++level, sc);
                level--; // make sure level stays the same for this recursion
            }
        }

        return subchapters;
    }
}

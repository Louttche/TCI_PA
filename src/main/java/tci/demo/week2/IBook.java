package tci.demo.week2;

import java.util.Collection;
import java.util.List;

public interface IBook {

    String GetName();
    String GetAuthor();
    List<Chapter> GetChapters();
    Collection<String> GetTOC(Integer level);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

}

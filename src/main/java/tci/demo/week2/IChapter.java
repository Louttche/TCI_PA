package tci.demo.week2;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IChapter {

    String GetName();
    int GetChapterNumber();
    Chapter GetParentChapter();
    Set<Chapter> GetSubchapters();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

}

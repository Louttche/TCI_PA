package tci.demo.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class BookTest {

    private static String VALID_NAME = "Game of the Rings";
    private static String VALID_AUTHOR = "Juju Nono";
    private static List<Chapter> chapters = new ArrayList();

    /**
     * @verifies throw IllegalArgumentException if name is null
     * @see Book#Book(String, String, java.util.List)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionIfNameIsNull() throws Exception {
        // Add some mocked chapters so a valid collection can be passed to constructor
        chapters.add(mock(Chapter.class));
        chapters.add(mock(Chapter.class));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Book(null, VALID_AUTHOR, chapters);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if author is null
     * @see Book#Book(String, String, java.util.List)
     */
    @Test
    public void Book_shouldThrowIllegalArgumentExceptionIfAuthorIsNull() throws Exception {
        // Add some mocked chapters so a valid collection can be passed to constructor
        chapters.add(mock(Chapter.class));
        chapters.add(mock(Chapter.class));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Book(VALID_NAME, null, chapters);
        });
    }
}
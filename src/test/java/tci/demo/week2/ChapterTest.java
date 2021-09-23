package tci.demo.week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class ChapterTest {

    private static Integer VALID_NUMBER = 1;
    private static String VALID_NAME = "The Rise of the Dragons";
    //private static Chapter VALID_PARENT = new Chapter(1, "The Start of it All", null);
    private static Chapter VALID_PARENT = mock(Chapter.class);


    /**
     * @verifies throw IllegalArgumentException if number is null
     * @see Chapter#Chapter(Integer, String, Chapter)
     */
    @Test
    public void Chapter_shouldThrowIllegalArgumentExceptionIfNumberIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Chapter(null, VALID_NAME, VALID_PARENT);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if name is null
     * @see Chapter#Chapter(Integer, String, Chapter)
     */
    @Test
    public void Chapter_shouldThrowIllegalArgumentExceptionIfNameIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Chapter(VALID_NUMBER, null, VALID_PARENT);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if number and name of chapter already exists
     * @see Chapter#Chapter(Integer, String, Chapter)

    @Test
    public void Chapter_shouldThrowIllegalArgumentExceptionIfNumberAndNameOfChapterAlreadyExists() throws Exception {

        // mock Chapter A that will 'already exist'
        Chapter a = mock(Chapter.class);

        // mock behavior
        // ?TODO: Get parameters that would be passed in constructor instead of "VALID_NUMBER/NAME"
        when(a.GetChapterNumber()).thenReturn(VALID_NUMBER);
        when(a.GetName()).thenReturn(VALID_NAME);

        // get name and number of mocked chapter
        Integer a_number = a.GetChapterNumber();
        String a_name = a.GetName();

        // try and add new Chapter B that has the same number + name
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Chapter(a_number, a_name,null);
        });
    }*/
}
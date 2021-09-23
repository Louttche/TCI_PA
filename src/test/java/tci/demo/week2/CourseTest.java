package tci.demo.week2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tci.demo.week1.Course;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CourseTest {

    private static String VALID_NAME = "Testing and Continuous Integration";
    private static String VALID_CODE = "TCI";
    private static int VALID_EC = 3;

    /**
     * @verifies only take in valid values
     * @see tci.demo.week1.Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldOnlyTakeInValidValues() throws Exception {
        //TODO auto-generated
        //act

        tci.demo.week1.Course sut = new tci.demo.week1.Course(VALID_NAME, VALID_EC, VALID_CODE);
        //arrange // assert

        assertThat(sut.getName()).isEqualTo(VALID_NAME);
        assertThat(sut.getEc()).isEqualTo(VALID_EC);
        assertThat(sut.getCode()).isEqualTo(VALID_CODE);
    }

    /**
     * @verifies throw IllegalArgumentException if name is null
     * @see tci.demo.week1.Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfNameIsNull() throws Exception {
        //TODO auto-generated
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new tci.demo.week1.Course(null, VALID_EC, VALID_CODE);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if code is shorter or longer
     * @see tci.demo.week1.Course#Course(String, Integer, String)
     */
    @ParameterizedTest
    @MethodSource("generateCodeWithInvalidSize")
    public void Course_shouldThrowIllegalArgumentExceptionIfCodeIsShorterOrLonger(String code) throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->{
           new tci.demo.week1.Course(VALID_NAME, VALID_EC, code);
        });
    }

    private static Stream<String> generateCodeWithInvalidSize() {
        return Stream.of("", "A", "AB", "ab", "abcd", "ABCd", "abc", "aBC", "ABCDE", "abcde");
    }

    /**
     * @verifies throw IllegalArgumentException if code is not in uppercase
     * @see tci.demo.week1.Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfCodeIsNotInUppercase() throws Exception {
        String invalid_code = "Abcd";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new tci.demo.week1.Course(VALID_NAME, VALID_EC, invalid_code);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if ec is negative
     * @see tci.demo.week1.Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfEcIsNegative() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, -5, VALID_CODE);
        });
    }
}
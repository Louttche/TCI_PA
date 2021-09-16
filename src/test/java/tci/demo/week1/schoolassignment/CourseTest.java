package tci.demo.week1.schoolassignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CourseTest {

    private static String VALID_NAME = "Testing and Continuous Integration";
    private static String VALID_CODE = "TCI";
    private static int VALID_EC = 3;

    @Test
    void getEc() {
    }

    @Test
    void getName() {
    }

    @Test
    void getCode() {
    }

    /**
     * @verifies only take in valid values
     * @see Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldOnlyTakeInValidValues() throws Exception {
        //TODO auto-generated
        //act

        Course sut = new Course(VALID_NAME, VALID_EC, VALID_CODE);
        //arrange // assert

        assertThat(sut.getName()).isEqualTo(VALID_NAME);
        assertThat(sut.getEc()).isEqualTo(VALID_EC);
        assertThat(sut.getCode()).isEqualTo(VALID_CODE);
    }

    /**
     * @verifies throw IllegalArgumentException if name is null
     * @see Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfNameIsNull() throws Exception {
        //TODO auto-generated
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(null, VALID_EC, VALID_CODE);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if code is shorter or longer
     * @see Course#Course(String, Integer, String)
     */
    @ParameterizedTest
    @MethodSource("generateCodeWithInvalidSize")
    public void Course_shouldThrowIllegalArgumentExceptionIfCodeIsShorterOrLonger(String code) throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->{
           new Course(VALID_NAME, VALID_EC, code);
        });
    }

    private static Stream<String> generateCodeWithInvalidSize() {
        return Stream.of("", "A", "AB", "ab", "abcd", "ABCd", "abc", "aBC", "ABCDE", "abcde");
    }

    /**
     * @verifies throw IllegalArgumentException if code is not in uppercase
     * @see Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfCodeIsNotInUppercase() throws Exception {
        String invalid_code = "Abcd";

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, VALID_EC, invalid_code);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if ec is negative
     * @see Course#Course(String, Integer, String)
     */
    @Test
    public void Course_shouldThrowIllegalArgumentExceptionIfEcIsNegative() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, -5, VALID_CODE);
        });
    }
}
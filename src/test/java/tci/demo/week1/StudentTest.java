package tci.demo.week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StudentTest {

    private static Integer VALID_STUDENT_NUMBER = 12345;
    private static String VALID_STUDENT_NAME = "Jon van den Berg";

    /**
     * @verifies throw IllegalArgumentException if studentNumber is negative
     * @see Student#Student(int, String)
     */
    @Test
    public void Student_shouldThrowIllegalArgumentExceptionIfStudentNumberIsNegative() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Student s = new Student(-12345, VALID_STUDENT_NAME);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if studentNumber is not 5 digits
     * @see Student#Student(int, String)
     */
    @ParameterizedTest
    @MethodSource("generateNumberWithInvalidSize")
    public void Student_shouldThrowIllegalArgumentExceptionIfStudentNumberIsNot5Digits(Integer code) throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Student s = new Student(code, VALID_STUDENT_NAME);
        });
    }

    private static Stream<Integer> generateNumberWithInvalidSize() {
        return Stream.of(1234, 123, 12, 1, 123456);
    }

    /**
     * @verifies throw IllegalArgumentException if semester is not in range 1 to 8
     * @see Student#Student(int, String)
     */
    @Test
    public void Student_shouldThrowIllegalArgumentExceptionIfSemesterIsNotInRange1To8() throws Exception {
        Assertions.fail("Not yet implemented");
    }
}
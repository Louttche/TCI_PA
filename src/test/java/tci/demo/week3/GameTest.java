package tci.demo.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class GameTest {

    private int VALID_ID = 3;
    private List<Member> VALID_MEMBERS = new ArrayList<>();
    /**
     * @verifies Throw IncorrectIdException if id is invalid
     * @see Game#Game(int, java.util.List)
     */
    @ParameterizedTest
    @MethodSource("generateInvalidID")
    public void Game_shouldThrowIncorrectIdExceptionIfIdIsInvalid(Integer id) throws Exception {
        VALID_MEMBERS.add(mock(Member.class));
        VALID_MEMBERS.add(mock(Member.class));

        assertThatExceptionOfType(IncorrectIdException.class).isThrownBy(() -> {
            new Game(id, VALID_MEMBERS);
        });
    }

    private static Stream<Integer> generateInvalidID() {
        return Stream.of(-5, 0);
    }

    /**
     * @verifies Throw IllegalArgumentException if players is null
     * @see Game#Game(int, java.util.List)
     */
    @Test
    public void Game_shouldThrowIllegalArgumentExceptionIfPlayersIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Game(VALID_ID, null);
        });
    }
}
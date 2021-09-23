package tci.demo.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class PlayerScoreTest {

    private Integer VALID_SCORE = 5;
    private Member VALID_MEMBER = mock(Member.class);
    private Game VALID_GAME = mock(Game.class);

    /**
     * @verifies throw IllegalArgumentException if score is null
     * @see PlayerScore#PlayerScore(Integer, Game, Member)
     */
    @Test
    public void PlayerScore_shouldThrowIllegalArgumentExceptionIfScoreIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           new PlayerScore(null, VALID_GAME, VALID_MEMBER);
        });
    }
}
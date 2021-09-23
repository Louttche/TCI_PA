package tci.demo.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class DartsAssociationTest {

    private List<Member> VALID_MEMBERS = new ArrayList<>();
    private List<Game> VALID_GAMES = new ArrayList<>();

    /**
     * @verifies throw IllegalArgumentException if players is null
     * @see DartsAssociation#DartsAssociation(java.util.List, java.util.List)
     */
    @Test
    public void DartsAssociation_shouldThrowIllegalArgumentExceptionIfPlayersIsNull() throws Exception {
        VALID_GAMES.add(mock(Game.class));
        VALID_GAMES.add(mock(Game.class));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DartsAssociation(null, VALID_GAMES);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if games is null
     * @see DartsAssociation#DartsAssociation(java.util.List, java.util.List)
     */
    @Test
    public void DartsAssociation_shouldThrowIllegalArgumentExceptionIfGamesIsNull() throws Exception {
        VALID_MEMBERS.add(mock(Member.class));
        VALID_MEMBERS.add(mock(Member.class));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new DartsAssociation(VALID_MEMBERS, null);
        });
    }
}
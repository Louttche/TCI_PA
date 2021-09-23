package tci.demo.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class MemberTest {

    private Game VALID_GAME = mock(Game.class);
    private String VALID_NAME = "Joe";
    private Integer VALID_NUM_OF_MEMBERS = 5;
    private List<Integer> VALID_SCORES = new ArrayList<>();
    private DartsAssociation VALID_DA = mock(DartsAssociation.class);

    /**
     * @verifies throw NonUniqueNameException if adding member without unique name
     * @see Member#Member(String)
     */
    @Test
    public void Member_shouldThrowNonUniqueNameExceptionIfAddingMemberWithoutUniqueName() throws Exception, NonUniqueNameException {
        List<Game> games = new ArrayList<>();
        games.add(mock(Game.class));
        List<Member> members = new ArrayList<>();
        DartsAssociation example_da = new DartsAssociation(members, games);

        example_da.AddMember(VALID_NAME);

        assertThatExceptionOfType(NonUniqueNameException.class).isThrownBy(() -> {
            example_da.AddMember(VALID_NAME);
        });
    }

    /**
     * @verifies throw IllegalArgumentException if name is null
     * @see Member#Member(String)
     */
    @Test
    public void Member_shouldThrowIllegalArgumentExceptionIfNameIsNull() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Member(null);
        });
    }
}
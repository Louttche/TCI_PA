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

    /**
     * @verifies throw NonUniqueNameException if adding member without unique name
     * @see Member#Member(String)
     */
    @Test
    public void Member_shouldThrowNonUniqueNameExceptionIfAddingMemberWithoutUniqueName() throws Exception {
        List<Member> members = new ArrayList<>();
        members.add(mock(Member.class));
        members.add(mock(Member.class));
        members.add(mock(Member.class));

        when(VALID_GAME.GetMembers()).thenReturn(members);

        // TODO: Assert that an exception is thrown
        Assertions.fail("Not yet implemented");
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
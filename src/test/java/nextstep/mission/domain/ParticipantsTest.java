package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {

    @Test
    void constructor() {
        Participants participants = new Participants(
                Arrays.asList(
                        new Participant("user1"),
                        new Participant("user2"),
                        new Participant("user3"),
                        new Participant("user4")
                )
        );

        assertThat(participants.size()).isEqualTo(4);
        assertThat(participants.getPosition("user1")).isNotNull();
        assertThat(participants.getPosition("user4")).isNotNull();
    }

    @Test
    void getParticipantNumber() {
        Participants participants = new Participants(Arrays.asList(
                new Participant("user1"),
                new Participant("user2"),
                new Participant("user3"),
                new Participant("user4")
        ));

        assertThat(participants.getPosition("user1")).isEqualTo(0);
        assertThat(participants.getPosition("user2")).isEqualTo(1);
        assertThat(participants.getPosition("user3")).isEqualTo(2);
        assertThat(participants.getPosition("user4")).isEqualTo(3);
    }

    @Test
    void getParticipantNumberThrow() {
        assertThatThrownBy(() ->
                new Participants(Arrays.asList(
                        new Participant("user1")
                )).getPosition("undefined")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

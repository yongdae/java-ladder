package nextstep.mission.view;

import nextstep.mission.domain.Participants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputScannerTest {

    @Test
    void getUsers() {
        Participants users = InputScanner.getUsers("user1,user2,user3,user4");

        assertThat(users.size()).isEqualTo(4);
        assertThat(users.getPosition("user1")).isNotNull();
        assertThat(users.getPosition("user2")).isNotNull();
        assertThat(users.getPosition("user3")).isNotNull();
        assertThat(users.getPosition("user4")).isNotNull();
    }

    @Test
    void getResults() {
        List<String> results = InputScanner.getResults("꽝,5000,꽝,3000");

        assertThat(results).hasSize(4);
        assertThat(results).containsExactly(
                "꽝",
                "5000",
                "꽝",
                "3000"
        );
    }
}

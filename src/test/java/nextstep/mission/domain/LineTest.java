package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void init() {
        int size = 5;
        assertThat(Line.init(size).getPoints().size()).isEqualTo(size);
    }

    @Test
    public void move() {
        assertThat(new Line(Arrays.asList(Point.first(false))).move(0)).isEqualTo(0);
        assertThat(new Line(Arrays.asList(Point.first(true))).move(0)).isEqualTo(1);
    }
}

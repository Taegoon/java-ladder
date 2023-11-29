package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("사다리 길이 생성 확인")
    public void createLadderTest(int ladderSize) throws Exception {

        int countOfPerson = 5;
        Ladder ladder = new Ladder(countOfPerson, ladderSize);
        List<Line> lines = ladder.lines();
        assertThat(lines.size()).isEqualTo(ladderSize);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("사다리 길이 유효성 확인")
    public void ladderSizeExceptionTest(int ladderSize) throws Exception {

        int countOfPerson = 5;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(countOfPerson, ladderSize);
        });
    }
}
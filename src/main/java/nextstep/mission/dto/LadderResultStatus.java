package nextstep.mission.dto;

import nextstep.mission.domain.Ladder;
import nextstep.mission.domain.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderResultStatus {
    private Map<String, String> status;

    private LadderResultStatus(LadderPreset ladderPreset) {
        status = new HashMap<>();

        Participants participants = ladderPreset.getParticipants();
        Ladder ladder = ladderPreset.getLadder();
        List<String> results = ladderPreset.getResults();

        IntStream.range(0, participants.size())
                .forEach(position -> {
                    String participant = String.valueOf(participants.get(position));
                    String result = results.get(ladder.getResult(participant));

                    status.put(participant, result);
                });
    }

    public static LadderResultStatus make(LadderPreset ladderPreset) {
        return new LadderResultStatus(ladderPreset);
    }

    public String getResult(String target) {
        return status.get(target);
    }
}

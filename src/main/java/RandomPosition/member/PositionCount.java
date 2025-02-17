package RandomPosition.member;

import RandomPosition.member.Dto.PositionList;
import RandomPosition.member.Dto.PositionNumber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PositionCount {

    private final MemberRepository memberRepository;

    public PositionCount(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isPossible(Position position) {
        long count = memberRepository.countByPosition(position);
        if (position == Position.First && count >= 4) {
            return false;
        }
        if (position == Position.Second && count >= Position.Second.getCapacity()) {
            return false;
        }
        if (position == Position.Third && count >= 4) {
            return false;
        }
        return true;
    }

    public List<PositionNumber> randomPick() {
        List<PositionNumber> numbers = new ArrayList<>();

        List<Member> first = memberRepository.findByPosition(Position.First);
        Collections.shuffle(first);

        List<Member> second = memberRepository.findByPosition(Position.Second);
        Collections.shuffle(second);

        List<Member> third = memberRepository.findByPosition(Position.Third);
        Collections.shuffle(third);

        for (int i = 0; i < first.size(); i++) {
            PositionNumber positionNumber = new PositionNumber(i + 1, first.get(i).getName());
            numbers.add(positionNumber);
        }

        for (int i = 0; i < second.size(); i++) {
            PositionNumber positionNumber = new PositionNumber(i + 5, second.get(i).getName());
            numbers.add(positionNumber);
        }

        for (int i = 0; i < third.size(); i++) {
            PositionNumber positionNumber = new PositionNumber(i + 13, third.get(i).getName());
            numbers.add(positionNumber);
        }
        return numbers;
    }
}

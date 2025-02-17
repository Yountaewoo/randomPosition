package RandomPosition.member;

import RandomPosition.member.Dto.MemberListResponse;
import RandomPosition.member.Dto.MemberRequest;
import RandomPosition.member.Dto.MemberResponse;
import RandomPosition.member.Dto.PositionList;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PositionCount positionCount;

    public MemberService(MemberRepository memberRepository, PositionCount positionCount) {
        this.memberRepository = memberRepository;
        this.positionCount = positionCount;
    }

    public MemberListResponse getMembers() {
        return new MemberListResponse(
                memberRepository.findAll()
                        .stream()
                        .map(member -> new MemberResponse(member.getPosition(), member.getName(), member.getId()))
                        .toList());
    }

    @Transactional
    public MemberResponse putPosition(MemberRequest memberRequest, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NoSuchElementException("해당하는 사람이 없습니다."));
        boolean possible = positionCount.isPossible(memberRequest.position());
        if (!possible) {
            throw new IllegalArgumentException("자리가 꽉 찼습니다.");
        }
        member.setPosition(memberRequest.position());
        memberRepository.save(member);
        return new MemberResponse(member.getPosition(), member.getName(), member.getId());
    }

    public PositionList getPosition() {
        return new PositionList(positionCount.randomPick());
    }
}

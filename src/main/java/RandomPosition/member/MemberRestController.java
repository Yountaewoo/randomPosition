package RandomPosition.member;

import RandomPosition.member.Dto.MemberListResponse;
import RandomPosition.member.Dto.MemberRequest;
import RandomPosition.member.Dto.MemberResponse;
import RandomPosition.member.Dto.PositionList;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberRestController {

    private final MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public MemberListResponse getMembers() {
        return memberService.getMembers();
    }

    @PutMapping("/members/{memberId}")
    public MemberResponse putPosition(@PathVariable Long memberId,
                                      @RequestBody MemberRequest memberRequest) {
        return memberService.putPosition(memberRequest, memberId);
    }

    @GetMapping("/position")
    public PositionList getPositionList() {
        return memberService.getPosition();
    }
}

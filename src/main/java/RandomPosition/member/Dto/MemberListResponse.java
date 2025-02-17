package RandomPosition.member.Dto;

import java.util.List;

public record MemberListResponse(
        List<MemberResponse> members
) {
}

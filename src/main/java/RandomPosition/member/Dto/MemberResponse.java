package RandomPosition.member.Dto;

import RandomPosition.member.Position;

public record MemberResponse(
        Position position,
        String name,
        Long id
) {
}

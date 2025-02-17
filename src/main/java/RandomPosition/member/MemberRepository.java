package RandomPosition.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    long countByPosition(Position position);

    List<Member> findByPosition(Position position);
}

package RandomPosition;

import java.util.Arrays;
import java.util.List;

import RandomPosition.member.Member;
import RandomPosition.member.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initMembers(MemberRepository memberRepository) {
        return args -> {
            List<String> names = Arrays.asList(
                    "윤찬영", "정해준", "권상윤", "문인혁", "허재",
                    "이호연", "윤태우", "김성락", "전지예", "황승혁",
                    "이채현", "황효진", "김민성", "박현지", "문성희", "추민영"
            );
            names.forEach(name -> {
                // 초기 position 값은 0으로 지정합니다.
                Member member = new Member(name);
                memberRepository.save(member);
            });
        };
    }
}

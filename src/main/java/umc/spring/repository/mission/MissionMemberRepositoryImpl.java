package umc.spring.repository.mission;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.member.Member;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.region.Region;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MissionMemberRepositoryImpl implements MissionMemberCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void save(Mission mission, Member member) {

    }
}

package umc.spring.repository.mission;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.mission.Mission;
import umc.spring.domain.mission.QMission;
import umc.spring.domain.region.Region;
import umc.spring.repository.mission.MissionRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(MissionStatus missionStatus) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (missionStatus != null && missionStatus == MissionStatus.CHALLENGING) {
            predicate.and(mission.status.eq(MissionStatus.CHALLENGING));
        }
        else if (missionStatus != null && missionStatus == MissionStatus.COMPLETE) {
            predicate.and(mission.status.eq(MissionStatus.COMPLETE));
        }


        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }

    @Override
    public List<Mission> dynamicQueryWithBooleanBuilder(Region region, MissionStatus missionStatus) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(missionStatus == MissionStatus.CHALLENGING) {
            predicate.and(mission.region.eq(region));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }
}
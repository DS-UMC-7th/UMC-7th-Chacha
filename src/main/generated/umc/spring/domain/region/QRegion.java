package umc.spring.domain.region;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRegion is a Querydsl query type for Region
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRegion extends EntityPathBase<Region> {

    private static final long serialVersionUID = 523247170L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRegion region = new QRegion("region");

    public final umc.spring.domain.member.QAddress address;

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final ListPath<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission> missionList = this.<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission>createList("missionList", umc.spring.domain.mission.Mission.class, umc.spring.domain.mission.QMission.class, PathInits.DIRECT2);

    public final NumberPath<Long> region_id = createNumber("region_id", Long.class);

    public QRegion(String variable) {
        this(Region.class, forVariable(variable), INITS);
    }

    public QRegion(Path<? extends Region> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRegion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRegion(PathMetadata metadata, PathInits inits) {
        this(Region.class, metadata, inits);
    }

    public QRegion(Class<? extends Region> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new umc.spring.domain.member.QAddress(forProperty("address")) : null;
    }

}


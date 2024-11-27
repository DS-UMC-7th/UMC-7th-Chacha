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

    public static final QRegion region = new QRegion("region");

    public final StringPath city = createString("city");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final ListPath<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission> missionList = this.<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission>createList("missionList", umc.spring.domain.mission.Mission.class, umc.spring.domain.mission.QMission.class, PathInits.DIRECT2);

    public final NumberPath<Long> region_id = createNumber("region_id", Long.class);

    public final ListPath<umc.spring.domain.store.Store, umc.spring.domain.store.QStore> storeList = this.<umc.spring.domain.store.Store, umc.spring.domain.store.QStore>createList("storeList", umc.spring.domain.store.Store.class, umc.spring.domain.store.QStore.class, PathInits.DIRECT2);

    public final StringPath street = createString("street");

    public QRegion(String variable) {
        super(Region.class, forVariable(variable));
    }

    public QRegion(Path<? extends Region> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegion(PathMetadata metadata) {
        super(Region.class, metadata);
    }

}


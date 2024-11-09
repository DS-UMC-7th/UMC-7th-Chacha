package umc.spring.domain.store;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 30651752L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final umc.spring.domain.member.QAddress address;

    public final TimePath<java.time.LocalTime> closingTime = createTime("closingTime", java.time.LocalTime.class);

    public final ListPath<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission> missionList = this.<umc.spring.domain.mission.Mission, umc.spring.domain.mission.QMission>createList("missionList", umc.spring.domain.mission.Mission.class, umc.spring.domain.mission.QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final TimePath<java.time.LocalTime> openingTime = createTime("openingTime", java.time.LocalTime.class);

    public final ListPath<umc.spring.domain.review.Review, umc.spring.domain.review.QReview> reviewList = this.<umc.spring.domain.review.Review, umc.spring.domain.review.QReview>createList("reviewList", umc.spring.domain.review.Review.class, umc.spring.domain.review.QReview.class, PathInits.DIRECT2);

    public final NumberPath<Float> score = createNumber("score", Float.class);

    public final umc.spring.domain.global.QCategory storeCategory;

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final ListPath<umc.spring.domain.image.StoreImage, umc.spring.domain.image.QStoreImage> storeImages = this.<umc.spring.domain.image.StoreImage, umc.spring.domain.image.QStoreImage>createList("storeImages", umc.spring.domain.image.StoreImage.class, umc.spring.domain.image.QStoreImage.class, PathInits.DIRECT2);

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new umc.spring.domain.member.QAddress(forProperty("address")) : null;
        this.storeCategory = inits.isInitialized("storeCategory") ? new umc.spring.domain.global.QCategory(forProperty("storeCategory")) : null;
    }

}


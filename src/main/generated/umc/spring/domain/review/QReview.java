package umc.spring.domain.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1260673598L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final umc.spring.domain.global.QBaseEntity _super = new umc.spring.domain.global.QBaseEntity(this);

    public final StringPath comment = createString("comment");

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.member.QMember member;

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final ListPath<umc.spring.domain.image.ReviewImage, umc.spring.domain.image.QReviewImage> reviewImageList = this.<umc.spring.domain.image.ReviewImage, umc.spring.domain.image.QReviewImage>createList("reviewImageList", umc.spring.domain.image.ReviewImage.class, umc.spring.domain.image.QReviewImage.class, PathInits.DIRECT2);

    public final NumberPath<Integer> star = createNumber("star", Integer.class);

    public final umc.spring.domain.store.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.member.QMember(forProperty("member"), inits.get("member")) : null;
        this.store = inits.isInitialized("store") ? new umc.spring.domain.store.QStore(forProperty("store"), inits.get("store")) : null;
    }

}


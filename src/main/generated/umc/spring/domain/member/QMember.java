package umc.spring.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 307091330L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final umc.spring.domain.global.QBaseEntity _super = new umc.spring.domain.global.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birthDay = createString("birthDay");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final ListPath<umc.spring.domain.mapping.MemberAlarm, umc.spring.domain.mapping.QMemberAlarm> memberAlarmList = this.<umc.spring.domain.mapping.MemberAlarm, umc.spring.domain.mapping.QMemberAlarm>createList("memberAlarmList", umc.spring.domain.mapping.MemberAlarm.class, umc.spring.domain.mapping.QMemberAlarm.class, PathInits.DIRECT2);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission> memberMissionList = this.<umc.spring.domain.mapping.MemberMission, umc.spring.domain.mapping.QMemberMission>createList("memberMissionList", umc.spring.domain.mapping.MemberMission.class, umc.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.domain.mapping.MemberPrefer.class, umc.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final umc.spring.domain.image.QProfileImage profileImage;

    public final ListPath<umc.spring.domain.report.Report, umc.spring.domain.report.QReport> reportList = this.<umc.spring.domain.report.Report, umc.spring.domain.report.QReport>createList("reportList", umc.spring.domain.report.Report.class, umc.spring.domain.report.QReport.class, PathInits.DIRECT2);

    public final ListPath<umc.spring.domain.review.Review, umc.spring.domain.review.QReview> reviewList = this.<umc.spring.domain.review.Review, umc.spring.domain.review.QReview>createList("reviewList", umc.spring.domain.review.Review.class, umc.spring.domain.review.QReview.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profileImage = inits.isInitialized("profileImage") ? new umc.spring.domain.image.QProfileImage(forProperty("profileImage"), inits.get("profileImage")) : null;
    }

}


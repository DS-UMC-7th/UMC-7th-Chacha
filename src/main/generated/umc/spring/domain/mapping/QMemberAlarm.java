package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAlarm is a Querydsl query type for MemberAlarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAlarm extends EntityPathBase<MemberAlarm> {

    private static final long serialVersionUID = -2051423605L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAlarm memberAlarm = new QMemberAlarm("memberAlarm");

    public final umc.spring.domain.alarm.QAlarm alarm;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.member.QMember member;

    public QMemberAlarm(String variable) {
        this(MemberAlarm.class, forVariable(variable), INITS);
    }

    public QMemberAlarm(Path<? extends MemberAlarm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAlarm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAlarm(PathMetadata metadata, PathInits inits) {
        this(MemberAlarm.class, metadata, inits);
    }

    public QMemberAlarm(Class<? extends MemberAlarm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarm = inits.isInitialized("alarm") ? new umc.spring.domain.alarm.QAlarm(forProperty("alarm")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.member.QMember(forProperty("member"), inits.get("member")) : null;
    }

}


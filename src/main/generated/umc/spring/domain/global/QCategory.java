package umc.spring.domain.global;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = -1047195395L;

    public static final QCategory category = new QCategory("category");

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.spring.domain.mapping.MemberPrefer, umc.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.spring.domain.mapping.MemberPrefer.class, umc.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<umc.spring.domain.store.Store, umc.spring.domain.store.QStore> storeList = this.<umc.spring.domain.store.Store, umc.spring.domain.store.QStore>createList("storeList", umc.spring.domain.store.Store.class, umc.spring.domain.store.QStore.class, PathInits.DIRECT2);

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}


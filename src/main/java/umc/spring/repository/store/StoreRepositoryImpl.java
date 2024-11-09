package umc.spring.repository.store;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.store.QStore;
import umc.spring.domain.store.Store;
import com.querydsl.core.BooleanBuilder;
import umc.spring.repository.store.StoreRepositoryCustom;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(store.name.eq(name));
        }

//        if (score != null) {
//            predicate.and(store.point.goe(4.0f));
//        }

        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}
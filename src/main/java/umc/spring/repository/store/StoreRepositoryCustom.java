package umc.spring.repository.store;


import umc.spring.domain.store.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
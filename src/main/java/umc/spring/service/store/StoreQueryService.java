package umc.spring.service.store;

import umc.spring.domain.store.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float star);
}

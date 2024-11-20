package umc.spring.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.store.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
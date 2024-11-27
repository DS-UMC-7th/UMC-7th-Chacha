package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.region.Region;
import umc.spring.domain.store.Store;
import umc.spring.dto.store.StoreRequestDTO;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.store.StoreRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

//        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
    @Transactional
    public Store addStoreToRegion(StoreRequestDTO request) {
        System.out.println("Received StoreRequestDTO: " + request); // 디버깅 출력
        System.out.println("Region ID: " + request.getRegionId()); // regionId 값 확인

        if (request.getRegionId() == null) {
            throw new IllegalArgumentException("Region ID cannot be null");
        }


        // 해당 regionId를 가진 지역을 찾아옴
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        // Store 엔티티 생성
        Store store = new Store();
        store.setName(request.getName());
        store.setAddress(request.getAddress());
        store.setRegion(region); // 해당 지역에 가게 추가

        Store savedStore = storeRepository.save(store);
        region.getStoreList().add(savedStore); // 해당 지역에 가게 추가

        return savedStore;
    }

}
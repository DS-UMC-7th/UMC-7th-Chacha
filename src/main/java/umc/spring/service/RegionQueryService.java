package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.region.Region;
import umc.spring.domain.store.Store;
import umc.spring.repository.RegionRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryService {
    private final RegionRepository regionRepository;


    public Optional<Region> findRegionById(Long id) {
        return regionRepository.findById(id);
    }

}

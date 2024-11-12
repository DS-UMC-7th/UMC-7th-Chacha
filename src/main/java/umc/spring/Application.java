package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MissionStatus;
import umc.spring.domain.member.Member;
import umc.spring.domain.region.Region;
import umc.spring.domain.review.Review;
import umc.spring.repository.RegionRepository;
import umc.spring.service.RegionQueryService;
import umc.spring.service.mission.MissionQueryServiceImpl;
import umc.spring.service.store.StoreQueryService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//
//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			StoreQueryService storeService = context.getBean(StoreQueryService.class);
//			MissionQueryServiceImpl missionQueryService = context.getBean(MissionQueryServiceImpl.class);
//			RegionRepository regionRepository = context.getBean(RegionRepository.class);
//
//			// 파라미터 값 설정
//			String name = "요아정";
//			Float score = 4.0f;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name, score)
//					.forEach(System.out::println);
//
//			// 파라미터 값 설정
//			MissionStatus missionStatus = MissionStatus.CHALLENGING;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findMissionsByNameAndScore with parameters:");
//			System.out.println("Status: " + missionStatus);
//
//			missionQueryService.findMissionsByStatus(missionStatus)
//					.forEach(System.out::println);
//			/** 리뷰 작성 */
//			/** 지역별 미션 조회 */
//
//			// 파라미터 값 설정
//			MissionStatus missionStatus_home = MissionStatus.CHALLENGING;
//			Region region_seoul = regionRepository.findById(1L).get();
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findMissionsByNameAndScore with parameters:");
//			System.out.println("Region: " + "서울");
//			System.out.println("Status: " + missionStatus_home);
//
//			missionQueryService.findMissionsByRegionAndStatus(region_seoul, missionStatus_home)
//					.forEach(System.out::println);
//
//		};
	//}
//@Transactional(readOnly = true)
//@Bean
//public CommandLineRunner run(ApplicationContext context) {
//	return args -> {
//		StoreQueryService storeService = context.getBean(StoreQueryService.class);
//		MissionQueryServiceImpl missionQueryService = context.getBean(MissionQueryServiceImpl.class);
//		RegionQueryService regionQueryService = context.getBean(RegionQueryService.class);
//
//		// 파라미터 값 설정
//		MissionStatus missionStatus_home = MissionStatus.CHALLENGING;
//
//		// Region 조회 시 연관된 missionList를 미리 로드하도록 처리
//		Region region_seoul = regionQueryService.findRegionById(1L)
//				.orElseThrow(() -> new IllegalArgumentException("지역 정보를 찾을 수 없습니다."));
//
//
//		// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//		System.out.println("Executing findMissionsByRegionAndStatus with parameters:");
//		System.out.println("Region: " + "서울");
//		System.out.println("Status: " + missionStatus_home);
//
//		missionQueryService.findMissionsByRegionAndStatus(region_seoul, missionStatus_home)
//				.forEach(System.out::println);
//	};
//	}
//
}

package umc.spring.repository.foodCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.spring.domain.global.Category;
@Repository
public interface FoodCategoryRepository extends JpaRepository<Category, Long> {
}

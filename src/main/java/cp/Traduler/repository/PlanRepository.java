package cp.Traduler.repository;

import cp.Traduler.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findAllByUserNameOrderByStartDateAsc(String userName);
}

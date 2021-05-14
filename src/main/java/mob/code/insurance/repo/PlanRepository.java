package mob.code.insurance.repo;

import mob.code.insurance.bean.Plan;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PlanRepository extends Repository<Plan, Long> {
    Plan save(Plan plan);
    List<Plan> findByPortfolioCode(String code);
    void deleteAll();
}

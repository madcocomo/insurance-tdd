package mob.code.insurance.repo;

import mob.code.insurance.bean.Assured;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AssuredRepository extends Repository<Assured, Long> {
    Assured save(Assured assured);
    List<Assured> findAll();
    void deleteAll();
}

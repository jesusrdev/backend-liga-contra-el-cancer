package pe.org.ligacancer.specialty_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.specialty_service.model.Specialty;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Integer> {
}

package pe.org.ligacancer.doctor_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.doctor_service.model.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}

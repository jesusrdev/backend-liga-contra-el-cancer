package pe.org.ligacancer.patient_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.patient_service.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
}

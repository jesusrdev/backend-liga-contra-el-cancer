package pe.org.ligacancer.doctor_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.doctor_service.model.Doctor;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d WHERE d.idSpecialty = :idSpecialty")
    List<Doctor> findAllDoctor(int idSpecialty);
}

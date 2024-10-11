package pe.org.ligacancer.appointment_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.appointment_service.model.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

    List<Appointment> findAllByIdDoctor(int idDoctor);

    List<Appointment> findAllByIdPatient(int idPatient);
}

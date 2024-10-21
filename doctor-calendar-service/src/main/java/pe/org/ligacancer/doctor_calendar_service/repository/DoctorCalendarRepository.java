package pe.org.ligacancer.doctor_calendar_service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.org.ligacancer.doctor_calendar_service.model.DoctorCalendar;

import java.util.List;

@Repository
public interface DoctorCalendarRepository extends CrudRepository<DoctorCalendar, Integer> {

    @Query("SELECT d FROM DoctorCalendar d WHERE d.doctorId = :doctorId")
    List<DoctorCalendar> findAllCalendar(int doctorId);
}

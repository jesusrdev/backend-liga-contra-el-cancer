package pe.org.ligacancer.doctor_calendar_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.doctor_calendar_service.model.DoctorCalendar;
import pe.org.ligacancer.doctor_calendar_service.repository.DoctorCalendarRepository;

import java.util.List;

@Service
public class DoctorCalendarService implements IDoctorCalendarService {

    @Autowired
    private DoctorCalendarRepository doctorCalendarRepository;

    @Override
    public void save(DoctorCalendar doctorCalendar) {
        doctorCalendarRepository.save(doctorCalendar);
    }

    @Override
    public List<DoctorCalendar> findAll() {
        return (List<DoctorCalendar>) doctorCalendarRepository.findAll();
    }

    @Override
    public DoctorCalendar findDoctorCalendarById(int id) {
        return doctorCalendarRepository.findById(id).orElseThrow();
    }

    @Override
    public List<DoctorCalendar> findAllByDoctorId(int idDoctor) {
        return doctorCalendarRepository.findAllCalendar(idDoctor);
    }
}

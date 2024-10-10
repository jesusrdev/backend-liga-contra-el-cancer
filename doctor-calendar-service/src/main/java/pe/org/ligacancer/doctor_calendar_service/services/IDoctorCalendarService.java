package pe.org.ligacancer.doctor_calendar_service.services;

import pe.org.ligacancer.doctor_calendar_service.model.DoctorCalendar;

import java.util.List;

public interface IDoctorCalendarService {

    public void save(DoctorCalendar doctorCalendar);

    public List<DoctorCalendar> findAll();

    public DoctorCalendar findDoctorCalendarById(int id);

    public List<DoctorCalendar> findAllByDoctorId(int idDoctor);
}

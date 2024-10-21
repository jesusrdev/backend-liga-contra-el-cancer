package pe.org.ligacancer.appointment_service.service;

import pe.org.ligacancer.appointment_service.dto.AppointmentCreateDTO;
import pe.org.ligacancer.appointment_service.model.Appointment;

import java.util.List;

public interface IAppointmentService {

    void saveAppointment(AppointmentCreateDTO appointmentCreateDTO);

    Appointment updateAppointment(int id, AppointmentCreateDTO appointmentUpdateDTO);

    Iterable<Appointment> findAllAppointments();

    Appointment findAppointmentById(int id);

    List<Appointment> findAppointmentsByIdPatient(int idPatient);

    List<Appointment> findAppointmentsByIdDoctor(int idDoctor);
}

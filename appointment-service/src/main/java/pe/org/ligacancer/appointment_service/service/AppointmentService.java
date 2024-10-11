package pe.org.ligacancer.appointment_service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.appointment_service.dto.AppointmentCreateDTO;
import pe.org.ligacancer.appointment_service.model.Appointment;
import pe.org.ligacancer.appointment_service.repository.AppointmentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public void saveAppointment(AppointmentCreateDTO appointmentCreateDTO) {
        appointmentRepository.save(Appointment.builder()
                .idPatient(appointmentCreateDTO.getIdPatient())
                .idDoctor(appointmentCreateDTO.getIdDoctor())
                .status("pendiente")
                .reason(appointmentCreateDTO.getReason())
                .date(appointmentCreateDTO.getDate())
                .shift(appointmentCreateDTO.getShift())
                .build());
    }

    @Override
    public Appointment updateAppointment(int id, AppointmentCreateDTO appointmentUpdateDTO) {
         var appointment = appointmentRepository.findById(id).orElseThrow();
         appointment.setIdPatient(appointmentUpdateDTO.getIdPatient());
         appointment.setIdDoctor(appointmentUpdateDTO.getIdDoctor());
         appointment.setStatus(appointmentUpdateDTO.getStatus());
         appointment.setReason(appointmentUpdateDTO.getReason());
         appointment.setDate(appointmentUpdateDTO.getDate());
         appointment.setShift(appointmentUpdateDTO.getShift());
         return appointmentRepository.save(appointment);
    }

    @Override
    public Iterable<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointmentById(int id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Appointment> findAppointmentsByIdPatient(int idPatient) {
        return appointmentRepository.findAllByIdPatient(idPatient);
    }

    @Override
    public List<Appointment> findAppointmentsByIdDoctor(int idDoctor) {
        return appointmentRepository.findAllByIdDoctor(idDoctor);
    }
}

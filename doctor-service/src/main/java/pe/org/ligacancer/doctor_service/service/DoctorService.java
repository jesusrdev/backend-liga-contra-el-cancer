package pe.org.ligacancer.doctor_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.doctor_service.client.AppointmentClient;
import pe.org.ligacancer.doctor_service.client.DoctorCalendarClient;
import pe.org.ligacancer.doctor_service.client.SpecialtyClient;
import pe.org.ligacancer.doctor_service.dto.AppointmentDTO;
import pe.org.ligacancer.doctor_service.dto.DoctorCalendarDTO;
import pe.org.ligacancer.doctor_service.dto.DoctorCreateDTO;
import pe.org.ligacancer.doctor_service.dto.SpecialtyDTO;
import pe.org.ligacancer.doctor_service.http.response.AppointmentsByDoctorResponse;
import pe.org.ligacancer.doctor_service.http.response.CalendarByDoctorResponse;
import pe.org.ligacancer.doctor_service.http.response.DoctorDetailed;
import pe.org.ligacancer.doctor_service.model.Doctor;
import pe.org.ligacancer.doctor_service.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService implements IDoctorService {

    public final DoctorRepository doctorRepository;
    public final SpecialtyClient specialtyClient;
    private final DoctorCalendarClient doctorCalendarClient;
    private final AppointmentClient appointmentClient;

    @Override
    public Doctor saveDoctor(DoctorCreateDTO doctorCreateDTO) {
        return doctorRepository.save(Doctor.builder()
                .name(doctorCreateDTO.getName())
                .lastName(doctorCreateDTO.getLastName())
                .address(doctorCreateDTO.getAddress())
                .idSpecialty(doctorCreateDTO.getIdSpecialty())
                .phone(doctorCreateDTO.getPhone())
                .dni(doctorCreateDTO.getDni())
                .build());
    }

    @Override
    public Object findAllDoctors(String method) {
        var doctors = doctorRepository.findAll();
        if (method.equals("detailed")) {
            var listDoctors = new ArrayList<DoctorDetailed>();
            for (var doctor : doctors) {
                // TODO: Implement the specialty client
                var specialty = specialtyClient.findSpecialtyById(doctor.getIdSpecialty());
                listDoctors.add(DoctorDetailed.builder()
                        .id(doctor.getId())
                        .name(doctor.getName())
                        .lastName(doctor.getLastName())
                        .address(doctor.getAddress())
                        .phone(doctor.getPhone())
                        .dni(doctor.getDni())
                        .specialty(specialty)
                        .build());
            }
            return listDoctors;
        }
        return doctors;
    }

    @Override
    public Object findDoctorById(int id, String method) {
        var doctor = doctorRepository.findById(id).orElseThrow();
        if (method.equals("detailed")) {
            // TODO: Implement the specialty client
            var specialty = SpecialtyDTO.builder()
                    .id(doctor.getIdSpecialty())
                    .description("specialty")
                    .build();
            return DoctorDetailed.builder()
                    .id(doctor.getId())
                    .name(doctor.getName())
                    .lastName(doctor.getLastName())
                    .address(doctor.getAddress())
                    .phone(doctor.getPhone())
                    .dni(doctor.getDni())
                    .specialty(specialty)
                    .build();
        }
        return doctor;
    }

    @Override
    public List<Doctor> findAllBySpecialtyId(int id) {
        return doctorRepository.findAllDoctor(id);
    }

    @Override
    public CalendarByDoctorResponse findAllCalendarByDoctor(int idDoctor) {

        Doctor doctor = doctorRepository.findById(idDoctor).orElse(new Doctor());

        List<DoctorCalendarDTO> calendars = doctorCalendarClient.findAllCalendarByDoctor(idDoctor);

        return CalendarByDoctorResponse.builder()
                .name(doctor.getName())
                .lastName(doctor.getLastName())
                .address(doctor.getAddress())
                .idSpecialty(doctor.getIdSpecialty())
                .phone(doctor.getPhone())
                .dni(doctor.getDni())
                .calendars(calendars)
                .build();

    }

    @Override
    public AppointmentsByDoctorResponse findAppointmentsByDoctorId(int idDoctor) {

        Doctor doctor = doctorRepository.findById(idDoctor).orElseThrow();
        List<AppointmentDTO> appointments = appointmentClient.getAppointmentsByDoctorId(idDoctor);

        return AppointmentsByDoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .lastName(doctor.getLastName())
                .address(doctor.getAddress())
                .idSpecialty(doctor.getIdSpecialty())
                .phone(doctor.getPhone())
                .dni(doctor.getDni())
                .appointments(appointments)
                .build();
    }


}

package pe.org.ligacancer.patient_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.patient_service.client.AppointmentClient;
import pe.org.ligacancer.patient_service.dto.AppointmentDTO;
import pe.org.ligacancer.patient_service.dto.PatientCreateDTO;
import pe.org.ligacancer.patient_service.http.response.AppointmentsByPatientResponse;
import pe.org.ligacancer.patient_service.model.Patient;
import pe.org.ligacancer.patient_service.repository.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;
    private final AppointmentClient appointmentClient;


    @Override
    public Patient savePatient(PatientCreateDTO patientCreateDTO) {
        return patientRepository.save(Patient.builder()
                .name(patientCreateDTO.getName())
                .lastName(patientCreateDTO.getLastName())
                .address(patientCreateDTO.getAddress())
                .phone(patientCreateDTO.getPhone())
                .dni(patientCreateDTO.getDni())
                .build());
    }

    @Override
    public Iterable<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(int id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public AppointmentsByPatientResponse findAppointmentsByPatientId(int idPatient) {
        Patient patient = patientRepository.findById(idPatient).orElseThrow();
        List<AppointmentDTO> appointments = appointmentClient.getAppointmentsByPatientId(idPatient);
        return AppointmentsByPatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .lastName(patient.getLastName())
                .address(patient.getAddress())
                .phone(patient.getPhone())
                .dni(patient.getDni())
                .appointments(appointments)
                .build();
    }
}

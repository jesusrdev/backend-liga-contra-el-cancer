package pe.org.ligacancer.patient_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.patient_service.dto.PatientCreateDTO;
import pe.org.ligacancer.patient_service.model.Patient;
import pe.org.ligacancer.patient_service.repository.PatientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService implements IPatientService {

    private final PatientRepository patientRepository;


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
}

package pe.org.ligacancer.patient_service.service;

import pe.org.ligacancer.patient_service.dto.PatientCreateDTO;
import pe.org.ligacancer.patient_service.model.Patient;

import java.util.List;

public interface IPatientService {

    public Patient savePatient(PatientCreateDTO patientCreateDTO);

    public Iterable<Patient> findAllPatients();

    public Patient findPatientById(int id);
}

package pe.org.ligacancer.patient_service.service;

import pe.org.ligacancer.patient_service.dto.PatientCreateDTO;
import pe.org.ligacancer.patient_service.http.response.AppointmentsByPatientResponse;
import pe.org.ligacancer.patient_service.model.Patient;

public interface IPatientService {

    public Patient savePatient(PatientCreateDTO patientCreateDTO);

    public Iterable<Patient> findAllPatients();

    public Patient findPatientById(int id);

    public AppointmentsByPatientResponse findAppointmentsByPatientId(int idPatient);
}

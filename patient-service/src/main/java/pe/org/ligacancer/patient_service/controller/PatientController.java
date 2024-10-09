package pe.org.ligacancer.patient_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.patient_service.dto.PatientCreateDTO;
import pe.org.ligacancer.patient_service.model.Patient;
import pe.org.ligacancer.patient_service.service.IPatientService;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final IPatientService patientService;

    @RequestMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> savePatient(@RequestBody PatientCreateDTO patientCreateDTO) {
        try {
            var patient = patientService.savePatient(patientCreateDTO);

            return ResponseEntity.ok(patient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping
    public ResponseEntity<Iterable<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAllPatients());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable int id) {
        return ResponseEntity.ok(patientService.findPatientById(id));
    }
}

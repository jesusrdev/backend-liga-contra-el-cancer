package pe.org.ligacancer.appointment_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.appointment_service.dto.AppointmentCreateDTO;
import pe.org.ligacancer.appointment_service.model.Appointment;
import pe.org.ligacancer.appointment_service.service.IAppointmentService;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createAppointment(
            @RequestBody AppointmentCreateDTO appointmentCreateDTO) {
        try {
            appointmentService.saveAppointment(appointmentCreateDTO);
            return ResponseEntity.ok("Appointment created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> updateAppointment(
            @PathVariable int id,
            @RequestBody AppointmentCreateDTO appointmentUpdateDTO) {
        try {
            return ResponseEntity.ok(appointmentService.updateAppointment(id, appointmentUpdateDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAppointments() {
        try {
            return ResponseEntity.ok(appointmentService.findAllAppointments());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Find appointment by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findAppointmentById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(appointmentService.findAppointmentById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Find appointments by id patient
    @GetMapping("/patient/{idPatient}")
    public ResponseEntity<?> findAppointmentsByIdPatient(@PathVariable int idPatient) {
        try {
            return ResponseEntity.ok(appointmentService.findAppointmentsByIdPatient(idPatient));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Find appointments by id doctor
    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<?> findAppointmentsByIdDoctor(@PathVariable int idDoctor) {
        try {
            return ResponseEntity.ok(appointmentService.findAppointmentsByIdDoctor(idDoctor));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

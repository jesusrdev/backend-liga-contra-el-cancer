package pe.org.ligacancer.doctor_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.doctor_service.dto.DoctorCreateDTO;
import pe.org.ligacancer.doctor_service.model.Doctor;
import pe.org.ligacancer.doctor_service.service.IDoctorService;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final IDoctorService doctorService;

    @PostMapping("/create")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Object> saveDoctor(@RequestBody DoctorCreateDTO doctorCreateDTO) {
        try {
            var doctor = doctorService.saveDoctor(doctorCreateDTO);

            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAllDoctors(
            @RequestParam(name = "method", defaultValue = "simple", required = false) String method
    ) {
        return ResponseEntity.ok(doctorService.findAllDoctors(method));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findDoctorById(
            @PathVariable int id,
            @RequestParam(name = "method", defaultValue = "simple", required = false) String method
    ) {
        return ResponseEntity.ok(doctorService.findDoctorById(id, method));
    }

    @GetMapping("/search-by-specialty/{idSpecialty}")
    public ResponseEntity<?> findAllBySpecialtyId(@PathVariable int idSpecialty){
        return ResponseEntity.ok(doctorService.findAllBySpecialtyId(idSpecialty));
    }

    @GetMapping("/search-by-calendar/{idDoctor}")
    public ResponseEntity<?> findAllCalendarByDoctor(@PathVariable int idDoctor){
        return ResponseEntity.ok(doctorService.findAllCalendarByDoctor(idDoctor));
    }

}

package pe.org.ligacancer.specialty_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.specialty_service.model.Specialty;
import pe.org.ligacancer.specialty_service.service.SpecialtyService;

@RestController
@RequestMapping("/api/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSpecialty(@RequestBody Specialty specialty){
        specialtyService.save(specialty);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(specialtyService.findAll());
    }

    @GetMapping("/{id}")
    public Specialty findSpecialtyById(@PathVariable int id){
        return specialtyService.findById(id);
    }

    @GetMapping("/search-doctor-by-Specialty/{idDoctor}")
    public ResponseEntity<?> findAllDoctorBySpecialty(@PathVariable int idDoctor){
        return ResponseEntity.ok(specialtyService.findAllDoctorsBySpecialty(idDoctor));
    }

}

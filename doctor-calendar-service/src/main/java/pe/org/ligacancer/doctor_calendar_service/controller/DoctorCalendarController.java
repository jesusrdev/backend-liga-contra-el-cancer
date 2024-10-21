package pe.org.ligacancer.doctor_calendar_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.doctor_calendar_service.model.DoctorCalendar;
import pe.org.ligacancer.doctor_calendar_service.services.IDoctorCalendarService;

@RestController
@RequestMapping("/api/doctor-calendar")
public class DoctorCalendarController {

    @Autowired
    private IDoctorCalendarService doctorCalendarService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctorCalendar(@RequestBody DoctorCalendar doctorCalendar){
        doctorCalendarService.save(doctorCalendar);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(doctorCalendarService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        DoctorCalendar doctorCalendar = doctorCalendarService.findDoctorCalendarById(id);
        return ResponseEntity.ok(doctorCalendar);
    }

    @GetMapping("/search-by-doctor/{idDoctor}")
    public ResponseEntity<?> findAllByDoctorId(@PathVariable int idDoctor){
        return ResponseEntity.ok(doctorCalendarService.findAllByDoctorId(idDoctor));
    }
}

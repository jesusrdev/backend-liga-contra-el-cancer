package pe.org.ligacancer.doctor_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.org.ligacancer.doctor_service.dto.DoctorCalendarDTO;

import java.util.List;

@FeignClient(name = "doctor-calendar-service", url = "http://localhost:8095/api/doctor-calendar")
public interface DoctorCalendarClient {

    @GetMapping("/search-by-doctor/{idDoctor}")
    List<DoctorCalendarDTO> findAllCalendarByDoctor(@PathVariable int idDoctor) ;

}

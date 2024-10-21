package pe.org.ligacancer.doctor_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.org.ligacancer.doctor_service.dto.AppointmentDTO;

import java.util.List;

@FeignClient(name = "appointment-service", url = "${application.config.appointment-service-url}")
public interface AppointmentClient {

    @GetMapping("/doctor/{idDoctor}")
    List<AppointmentDTO> getAppointmentsByDoctorId(@PathVariable int idDoctor);
}

package pe.org.ligacancer.patient_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.org.ligacancer.patient_service.dto.AppointmentDTO;

import java.util.List;

@FeignClient(name = "appointment-service", url = "${application.config.appointment-service-url}")
public interface AppointmentClient {

    @GetMapping("/patient/{idPatient}")
    List<AppointmentDTO> getAppointmentsByPatientId(@PathVariable int idPatient);
}

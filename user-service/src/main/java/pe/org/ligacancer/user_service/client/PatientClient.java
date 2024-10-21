package pe.org.ligacancer.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.org.ligacancer.user_service.dto.PatientCreateDTO;
import pe.org.ligacancer.user_service.dto.PatientDTO;

@FeignClient(name = "patient-service-client", url = "${application.config.patient-service-url}")
public interface PatientClient {

    @PostMapping("/create")
    PatientDTO savePatient(@RequestBody PatientCreateDTO patientCreateDTO);
}

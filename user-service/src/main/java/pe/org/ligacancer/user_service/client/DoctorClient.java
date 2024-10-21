package pe.org.ligacancer.user_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.org.ligacancer.user_service.dto.DoctorCreateDTO;
import pe.org.ligacancer.user_service.dto.DoctorDTO;

@FeignClient(name = "doctor-service-client", url = "${application.config.doctor-service-url}")
public interface DoctorClient {

    @PostMapping("/create")
    DoctorDTO saveDoctor(@RequestBody DoctorCreateDTO doctorCreateDTO);
}

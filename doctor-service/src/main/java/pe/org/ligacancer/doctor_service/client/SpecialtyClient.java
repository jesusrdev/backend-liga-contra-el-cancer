package pe.org.ligacancer.doctor_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.org.ligacancer.doctor_service.dto.SpecialtyDTO;

import java.util.List;

@FeignClient(name = "specialty-client", url = "${application.config.specialty-service-url}")
public interface SpecialtyClient {

    @GetMapping("/{id}")
    SpecialtyDTO findSpecialtyById(@PathVariable int id);
}

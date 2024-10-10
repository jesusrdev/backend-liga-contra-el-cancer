package pe.org.ligacancer.specialty_service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.org.ligacancer.specialty_service.dto.DoctorDTO;

import java.util.List;

@FeignClient(name = "doctor-service", url = "http://localhost:8094/api/doctors")
public interface DoctorClient {

    @GetMapping("/search-by-specialty/{idSpecialty}")
    List<DoctorDTO> findAllDoctorBySpecialty(@PathVariable int idSpecialty);
}

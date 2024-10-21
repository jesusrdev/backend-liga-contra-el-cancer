package pe.org.ligacancer.specialty_service.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.org.ligacancer.specialty_service.dto.DoctorDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorBySpecialtyResponse {
    private String description;
    private List<DoctorDTO> doctors;
}

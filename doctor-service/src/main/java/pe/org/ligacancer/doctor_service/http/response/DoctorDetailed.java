package pe.org.ligacancer.doctor_service.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.org.ligacancer.doctor_service.dto.SpecialtyDTO;
import pe.org.ligacancer.doctor_service.model.Doctor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDetailed {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String dni;

    SpecialtyDTO specialty;
}

package pe.org.ligacancer.doctor_service.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.org.ligacancer.doctor_service.dto.AppointmentDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentsByDoctorResponse {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private int idSpecialty;
    private String phone;
    private String dni;
    private List<AppointmentDTO> appointments;
}

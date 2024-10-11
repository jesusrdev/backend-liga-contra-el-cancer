package pe.org.ligacancer.patient_service.http.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.org.ligacancer.patient_service.dto.AppointmentDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentsByPatientResponse {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String dni;

    List<AppointmentDTO> appointments;
}

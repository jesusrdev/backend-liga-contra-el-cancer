package pe.org.ligacancer.patient_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentDTO {

    private int id;
    private int idPatient;
    private int idDoctor;
    private String status;
    private String reason;
    private String date;
    private String shift;
}

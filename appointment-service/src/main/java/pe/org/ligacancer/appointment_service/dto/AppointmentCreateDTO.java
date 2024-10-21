package pe.org.ligacancer.appointment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentCreateDTO {

    private int idPatient;
    private int idDoctor;
    private String status;
    private String reason;
    private Date date;
    private String shift;
}

package pe.org.ligacancer.doctor_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorCalendarDTO {
    private String dayWeek;
    private Date starTime;
    private Date endTime;
    private int doctorId;
}

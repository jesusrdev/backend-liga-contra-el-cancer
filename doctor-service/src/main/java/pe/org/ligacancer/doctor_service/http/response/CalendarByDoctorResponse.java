package pe.org.ligacancer.doctor_service.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.org.ligacancer.doctor_service.dto.DoctorCalendarDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalendarByDoctorResponse {

    private String name;
    private String lastName;
    private String address;
    private int idSpecialty;
    private String phone;
    private String dni;
    private List<DoctorCalendarDTO> calendars;

}

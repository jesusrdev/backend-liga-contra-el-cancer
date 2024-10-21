package pe.org.ligacancer.user_service.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {

    private int id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String dni;
}

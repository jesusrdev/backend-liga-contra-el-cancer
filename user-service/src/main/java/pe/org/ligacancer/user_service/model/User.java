package pe.org.ligacancer.user_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_patient", nullable = true)
    private int idPatient;

    @Column(name = "id_doctor", nullable = true)
    private int idDoctor;

    private String email;
    private String password;
    private String role; //* admin, doctor, patient
    private String state; //* active, inactive, banned

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_login")
    private Date lastLogin;
}

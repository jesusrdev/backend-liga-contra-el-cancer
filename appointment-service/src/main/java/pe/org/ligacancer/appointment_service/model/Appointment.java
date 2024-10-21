package pe.org.ligacancer.appointment_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_patient")
    private int idPatient;
    @Column(name = "id_doctor")
    private int idDoctor;

    private String status;
    private String reason;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String shift; // Turno
}

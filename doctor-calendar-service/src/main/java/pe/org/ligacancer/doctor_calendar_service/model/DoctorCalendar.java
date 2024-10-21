package pe.org.ligacancer.doctor_calendar_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "doctor_calendar")
public class DoctorCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "day_week")
    private String dayWeek;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "star_time")
    private Date starTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "doctor_id")
    private int doctorId;
}

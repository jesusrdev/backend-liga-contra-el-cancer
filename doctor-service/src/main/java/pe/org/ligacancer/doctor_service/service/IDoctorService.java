package pe.org.ligacancer.doctor_service.service;

import pe.org.ligacancer.doctor_service.dto.DoctorCreateDTO;
import pe.org.ligacancer.doctor_service.model.Doctor;

public interface IDoctorService {

    public Doctor saveDoctor(DoctorCreateDTO doctorCreateDTO);

    public Object findAllDoctors(String method);

    public Object findDoctorById(int id, String method);
}

package pe.org.ligacancer.specialty_service.service;

import org.springframework.stereotype.Service;
import pe.org.ligacancer.specialty_service.http.response.DoctorBySpecialtyResponse;
import pe.org.ligacancer.specialty_service.model.Specialty;

public interface ISpecialtyService {

    public void save(Specialty specialty);

    public Iterable<Specialty> findAll();

    public Specialty findById(int id);

    public DoctorBySpecialtyResponse findAllDoctorsBySpecialty(int IdSpecialty);

}

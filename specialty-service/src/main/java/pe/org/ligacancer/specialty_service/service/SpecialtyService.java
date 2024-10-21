package pe.org.ligacancer.specialty_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.specialty_service.client.DoctorClient;
import pe.org.ligacancer.specialty_service.dto.DoctorDTO;
import pe.org.ligacancer.specialty_service.http.response.DoctorBySpecialtyResponse;
import pe.org.ligacancer.specialty_service.model.Specialty;
import pe.org.ligacancer.specialty_service.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService implements ISpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;


    @Autowired
    private DoctorClient doctorClient;

    @Override
    public void save(Specialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Override
    public Iterable<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty findById(int id) {
        return specialtyRepository.findById(id).orElseThrow();
    }

    @Override
    public DoctorBySpecialtyResponse findAllDoctorsBySpecialty(int IdSpecialty) {
        Specialty specialty = specialtyRepository.findById(IdSpecialty).orElseThrow();
        List<DoctorDTO> doctors = doctorClient.findAllDoctorBySpecialty(IdSpecialty);
        return DoctorBySpecialtyResponse.builder()
                .description(specialty.getDescription())
                .doctors(doctors)
                .build();
    }
}

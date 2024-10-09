package pe.org.ligacancer.user_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.org.ligacancer.user_service.client.PatientClient;
import pe.org.ligacancer.user_service.dto.PatientCreateDTO;
import pe.org.ligacancer.user_service.dto.PatientDTO;
import pe.org.ligacancer.user_service.model.User;
import pe.org.ligacancer.user_service.repository.UserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final PatientClient patientClient;

    @Override
    public void registerPatient(
            String email,
            String password,
            String name,
            String lastName,
            String address,
            String phone,
            String dni
    ) {
        PatientDTO patient = patientClient.savePatient(PatientCreateDTO.builder()
                .name(name)
                .lastName(lastName)
                .address(address)
                .phone(phone)
                .dni(dni)
                .build());
        userRepository.save(
                User.builder()
                        .email(email)
                        .password(password)
                        .role("patient")
                        .state("active")
                        .idPatient(patient.getId())
                        .creationDate(new Date())
                        .lastLogin(new Date())
                        .build()
        );
    }

    @Override
    public void registerDoctor(
            String email,
            String password,
            String name,
            String lastName,
            String address,
            String specialty,
            String phone,
            String dni
    ) {
        // TODO: Implement the save doctor client
        return;
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }
}

package pe.org.ligacancer.user_service.service;

import org.springframework.stereotype.Service;
import pe.org.ligacancer.user_service.model.User;

@Service
public interface IUserService {
    void registerPatient(
            String email,
            String password,
            String name,
            String lastName,
            String address,
            String phone,
            String dni
    );

    void registerDoctor(
            String email,
            String password,
            String name,
            String lastName,
            String address,
            int idSpecialty,
            String phone,
            String dni
    );

    Iterable<User> findAllUsers();
}

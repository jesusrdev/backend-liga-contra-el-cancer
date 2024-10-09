package pe.org.ligacancer.user_service.service;

import pe.org.ligacancer.user_service.model.User;

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
            String specialty,
            String phone,
            String dni
    );

    Iterable<User> findAllUsers();
}

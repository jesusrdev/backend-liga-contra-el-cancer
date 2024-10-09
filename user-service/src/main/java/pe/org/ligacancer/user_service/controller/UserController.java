package pe.org.ligacancer.user_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.org.ligacancer.user_service.model.User;
import pe.org.ligacancer.user_service.service.IUserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/register-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerPatient(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone,
            @RequestParam("dni") String dni
    ) {
        try {
            userService.registerPatient(
                    email,
                    password,
                    name,
                    lastName,
                    address,
                    phone,
                    dni
            );

            return ResponseEntity.ok("Patient created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> registerDoctor(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String lastName,
            @RequestParam int idSpecialty,
            @RequestParam String phone,
            @RequestParam String dni
    ) {
        try {
            userService.registerDoctor(
                    email,
                    password,
                    name,
                    lastName,
                    address,
                    idSpecialty,
                    phone,
                    dni
            );

            return ResponseEntity.ok("Doctor created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}

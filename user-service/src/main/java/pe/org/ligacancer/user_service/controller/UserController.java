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
    public void registerDoctor(
            @RequestBody String email,
            @RequestBody String password,
            @RequestBody String name,
            @RequestBody String lastName,
            @RequestBody String address,
            @RequestBody String specialty,
            @RequestBody String phone,
            @RequestBody String dni
    ) {
        userService.registerDoctor(
                email,
                password,
                name,
                lastName,
                address,
                specialty,
                phone,
                dni
        );
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}

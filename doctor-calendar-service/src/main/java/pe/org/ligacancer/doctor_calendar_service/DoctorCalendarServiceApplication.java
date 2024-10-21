package pe.org.ligacancer.doctor_calendar_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DoctorCalendarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorCalendarServiceApplication.class, args);
	}

}

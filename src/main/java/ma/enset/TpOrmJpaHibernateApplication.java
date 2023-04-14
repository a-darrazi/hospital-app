package ma.enset;

import ma.enset.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpOrmJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpOrmJpaHibernateApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(IHospitalService iHospitalService){
		return arg ->{

		};
	}
}

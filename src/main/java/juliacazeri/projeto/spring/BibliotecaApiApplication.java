package juliacazeri.projeto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BibliotecaApiApplication{

	public static void main (String[] args){
		SpringApplication.run(BibliotecaApiApplication.class, args);
	}
}
package mx.tec.web.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SitatyrChatAppBeApplication {
	/**
	 * Maini Method.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SitatyrChatAppBeApplication.class, args);
	}

	/**
	 *
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();	
	}

}

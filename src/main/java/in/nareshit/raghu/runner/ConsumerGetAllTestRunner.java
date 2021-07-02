package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.reactive.function.client.WebClient;

import in.nareshit.raghu.model.Student;
import reactor.core.publisher.Flux;

//@Component
public class ConsumerGetAllTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		//1. Define Producer URL
		String url = "http://localhost:8081";

		//2. Create WebClient Object
		WebClient client = WebClient.create(url);

		//3. Provide Request Information (method, path , body,header..etc)
		//4. Execute and covert response to Mono/Flux
		Flux<Student> flux = client
				.get()
				.uri("/student/all")
				.retrieve()
				.bodyToFlux(Student.class);


		//5. print result
		flux.doOnNext(System.out::println).blockLast();
		
	}

}

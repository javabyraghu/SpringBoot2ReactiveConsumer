package in.nareshit.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class ConsumerDeleteTestRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		//1. Define Producer URL
		String url = "http://localhost:8081";

		//2. Create WebClient Object
		WebClient client = WebClient.create(url);

		//3. Provide Request Information (method, path , body,header..etc)
		//4. Execute and covert response to Mono/Flux
		Mono<Void> mono = client
				.delete()
				.uri("/student/remove/{id}",1102)
				.retrieve()
				.bodyToMono(Void.class);


		//5. print result
		mono.subscribe(System.out::println);
		System.out.println("OBJECT DELETED!!");
	}

}

package com.mitocode.demoreactor;

import com.mitocode.demoreactor.transformacion.Transformacion;
import creacion.Creacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public void reactor(){
		Mono.just(new Persona("Edwar", "1", 30))
				.doOnNext(p -> log.info("[reactor] :"+p))
				.subscribe(p -> log.info("[reactor] :"+p));
	}

	public void rxjava2(){
		Observable.just(new Persona("Edwar", "1", 30))
				.doOnNext(p -> log.info("[rxjava2] :"+p))
				.subscribe(p -> log.info("[rxjava2] :"+p));
	}

	public void mono(){
		Mono.just(new Persona("Andres", "2",26)).subscribe(p -> log.info(p.toString()));
	}

	public void flux(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Kandy", "3",34));
		personas.add(new Persona("Nayive", "4",62));
		personas.add(new Persona("Majo", "5",20));

		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}

	public void fluxmono(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Kandy", "3",34));
		personas.add(new Persona("Nayive", "4",62));
		personas.add(new Persona("Majo", "5",20));

		Flux<Persona> fx =Flux.fromIterable(personas);
		fx.collectList().subscribe(lista -> log.info(lista.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//mono();
		//flux();
		//fluxmono();
		//Creacion app = new Creacion();
		//app.range();
		//app.repeat();
		Transformacion app2 = new Transformacion();
		//app2.map();
		app2.groupBy();
	}
}

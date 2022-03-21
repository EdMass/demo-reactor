package ejercicioClase;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.Persona;
import com.mitocode.demoreactor.Ventas;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void filterYDistinct() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));
        personas.add(new Persona("Ramiro", "3",37));
        personas.add(new Persona("Ramiro", "5",37));

        Flux.fromIterable(personas)
                .filter(p -> p.getEdad() > 34)
                .distinct()
                .subscribe(p -> log.info(p.toString()));

    }

    public void merge(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));
        personas.add(new Persona("Ramiro", "3",37));

        List<Persona> estudiantes = new ArrayList<>();
        personas.add(new Persona("Mauro", "7",27));
        personas.add(new Persona("Santiago", "8",25));
        personas.add(new Persona("Mariana", "9",20));
        personas.add(new Persona("Alex", "10",23));

        List<Ventas> ventas = new ArrayList<>();
        ventas.add(new Ventas(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(estudiantes);
        Flux<Ventas> fx3 = Flux.fromIterable(ventas);

        Flux.merge(fx1,fx2,fx3)
                .subscribe(p -> log.info(p.toString()));


    }

    public void empty(){
        Mono.just(new Persona("Edwar", "1", 30))
                .empty()   //No devuelve nada
                .defaultIfEmpty(new Persona("Pepito","0",100))
                .subscribe(p -> log.info(p.toString()));
    }

    public void map() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3", 34));
        personas.add(new Persona("Nayive", "4", 62));
        personas.add(new Persona("Majo", "5", 20));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad() - 10);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));
    }

    public void zip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));
        personas.add(new Persona("Ramiro", "3",37));

        List<Persona> estudiantes = new ArrayList<>();
        personas.add(new Persona("Mauro", "7",27));
        personas.add(new Persona("Santiago", "8",25));
        personas.add(new Persona("Mariana", "9",20));
        personas.add(new Persona("Alex", "10",23));

        List<Ventas> ventas = new ArrayList<>();
        ventas.add(new Ventas(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(estudiantes);
        Flux<Ventas> fx3 = Flux.fromIterable(ventas);

        //unir y operar con los flujos
       //Flux.zip(fx1,fx2, (p1, p2) -> String.format("Flux1 = %s, Flux2 = %s",p1,p2))
             //   .subscribe(p -> log.info(p));

        Flux.zip(fx1, fx2, fx3).subscribe(p -> log.info(p.toString()));

    }

    public void zipWith() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3", 34));
        personas.add(new Persona("Nayive", "4", 62));
        personas.add(new Persona("Majo", "5", 20));
        personas.add(new Persona("Ramiro", "3", 37));

        List<Persona> estudiantes = new ArrayList<>();
        personas.add(new Persona("Mauro", "7", 27));
        personas.add(new Persona("Santiago", "8", 25));
        personas.add(new Persona("Mariana", "9", 20));
        personas.add(new Persona("Alex", "10", 23));

        List<Ventas> ventas = new ArrayList<>();
        ventas.add(new Ventas(1, LocalDateTime.now()));

        Flux<Persona> fx1 = Flux.fromIterable(personas);
        Flux<Persona> fx2 = Flux.fromIterable(estudiantes);
        Flux<Ventas> fx3 = Flux.fromIterable(ventas);

        fx1.zipWith(fx2, (p1, p2) -> String.format("Flux1 = %s, Flux2 = %s",p1,p2))
                .subscribe(x -> log.info(x.toString()));
    }
}

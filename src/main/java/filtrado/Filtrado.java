package filtrado;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void filtrado(){
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona("Kandy", "3",34));
    personas.add(new Persona("Nayive", "4",62));
    personas.add(new Persona("Majo", "5",20));

    Flux.fromIterable(personas)
            .filter(p -> p.getEdad() > 34)
            .subscribe(p -> log.info(p.toString()));

    }

    public void  distinct(){
        Flux.fromIterable(List.of(1,1,2,3,2))
                .distinct()
                .subscribe(p -> log.info(p.toString()));

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));
        personas.add(new Persona("Ramiro", "3",37));

        Flux.fromIterable(personas)
                .distinct()
                .subscribe(p -> log.info(p.toString()));
    }

    public void take(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));
        personas.add(new Persona("Ramiro", "3",37));

        Flux.fromIterable(personas)
                .take(2)
                .subscribe(p -> log.info(p.toString()));
    }
}

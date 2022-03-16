package creacion;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void range(){
        Flux.range(0,3)
                .doOnNext(i -> log.info("i : "+i))
                .subscribe();
    }

    public void repeat(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));

        Flux.fromIterable(personas)
                .repeat(3)
                .subscribe(p -> log.info(p.toString()));
    }
}

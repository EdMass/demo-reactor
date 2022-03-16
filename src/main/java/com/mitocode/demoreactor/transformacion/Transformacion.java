package com.mitocode.demoreactor.transformacion;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void map(){
       /* List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "4",62));
        personas.add(new Persona("Majo", "5",20));

        Flux.fromIterable(personas)
                .map(p -> {
                    p.setEdad(p.getEdad()-10);
                    return p;
                })
                .subscribe(p -> log.info(p.toString()));*/
        Flux<Integer> fx = Flux.range(0,10);
        Flux<Integer> fx2 = fx.map(x -> x+10);
        fx2.subscribe(x -> log.info("X: "+x));
    }

    public void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Kandy", "3",34));
        personas.add(new Persona("Nayive", "3",62));
        personas.add(new Persona("Majo", "3",20));

        Flux.fromIterable(personas)
                .groupBy(Persona::getCedula)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}

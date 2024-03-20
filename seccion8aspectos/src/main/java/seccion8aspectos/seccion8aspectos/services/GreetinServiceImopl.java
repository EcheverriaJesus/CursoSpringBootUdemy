package seccion8aspectos.seccion8aspectos.services;

import org.springframework.stereotype.Service;

@Service
public class GreetinServiceImopl implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) {
        String greeting = phrase + " " + person;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("Algun Error");
    }

}

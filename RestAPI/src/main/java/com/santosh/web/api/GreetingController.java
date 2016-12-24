package com.santosh.web.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.web.model.Greeting;

@RestController
public class GreetingController {

    private static int nextId;
    private static Map<Integer, Greeting> greetingMap;

    @RequestMapping(value = "/api/greetings")
    public ResponseEntity<Collection<Greeting>> getGreetings() {
	return new ResponseEntity<>(greetingMap.values(), OK);
    }

    @RequestMapping(value = "/api/greetings/{id}")
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") final int id) {
	Greeting greeting = greetingMap.get(id);
	if (null == greeting) {
	    return new ResponseEntity<>(NOT_FOUND);
	}
	return new ResponseEntity<>(greeting, OK);
    }

    @RequestMapping(value = "/api/greetings", method = RequestMethod.POST)
    public ResponseEntity<Greeting> createGreeting(@RequestBody final Greeting greeting) {
	return new ResponseEntity<>(save(greeting), CREATED);
    }

    static {
	Greeting g1 = new Greeting();
	g1.setMessage("Hello from Earth!!");
	save(g1);
	Greeting g2 = new Greeting();
	g2.setMessage("Hello from Mars!!");
	save(g2);
    }

    private static Greeting save(final Greeting greeting) {
	if (null == greetingMap) {
	    greetingMap = new HashMap<>();
	    nextId = 1;
	}
	greeting.setId(nextId++);
	greetingMap.put(greeting.getId(), greeting);
	return greeting;
    }

}

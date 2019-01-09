package org.world.origin;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.world.origin.util.Log;

@SpringBootApplication
public class OriginApplication {
	
	private static final Logger log = Log.get();
	
	public static void main(String[] args) {
		SpringApplication.run(OriginApplication.class, args);
	}
}

package org.bam.rest.consumer.camelrestconsumer;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.bam.rest.consumer.route.FileCamelRouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelrestconsumerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CamelrestconsumerApplication.class, args);
		CamelContext ctx=new DefaultCamelContext();
		
			ctx.addRoutes(new FileCamelRouteBuilder());
			ctx.start();
			Thread.sleep(5000);
			ctx.stop();
			ctx.close();
			System.out.println("exit program");
	}

}
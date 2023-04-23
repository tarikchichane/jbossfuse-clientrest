package org.bam.rest.consumer.route;



import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.bam.rest.consumer.processor.FileCamelDownloadFile;
import org.bam.rest.consumer.processor.FileCamelProcessor;
import org.bam.rest.consumer.utils.FileCamelUtils;

public class FileCamelRouteBuilder extends RouteBuilder {
	private String responselistFile="";
	private static String listFileArray[];
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("timer://foo?fixedRate=true&period=6000").to("http://127.0.0.1:8181/cxf/fileservice/fileset/listFile").
		process(new FileCamelProcessor()).
		to("mock:result").process(new FileCamelDownloadFile()).log("end");
		
	}

}

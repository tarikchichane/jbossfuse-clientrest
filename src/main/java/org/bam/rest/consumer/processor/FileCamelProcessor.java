package org.bam.rest.consumer.processor;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.bam.rest.consumer.utils.FileCamelUtils;

public class FileCamelProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Message messageout=exchange.getIn().copy();
		String responselistFile=exchange.getIn().getBody(String.class);
		FileCamelUtils fu=new FileCamelUtils();
		String listFileArray[]=responselistFile.split(",");
		Map <String, Object> fileMap = new HashMap<String, Object>();
		String extension="";
		for (String filename : listFileArray) {
			extension=fu.getExtension(filename);
			fileMap.put(filename, extension);
		}
		messageout.setHeaders(fileMap);
		exchange.setMessage(messageout);
	}
		
}

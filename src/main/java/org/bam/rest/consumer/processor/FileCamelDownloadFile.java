package org.bam.rest.consumer.processor;


import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileCamelDownloadFile implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String newFileName="";
		Map<String, Object> fileMap = exchange.getMessage().getHeaders();
		for (Entry<String, Object>  fileEntry:fileMap.entrySet()) {
			String fileName = fileEntry.getKey();
			String extension = fileEntry.getValue().toString();
			newFileName=fileName.replaceAll(".txt", extension);
			System.out.println("new file name"+newFileName);
		}			
	}

}

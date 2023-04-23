package org.bam.rest.consumer.utils;

public class FileCamelUtils {

	public FileCamelUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getExtension(String fileName) {
		String extension="";
		char c=fileName.charAt(4);
		switch (c) {
		
		case '1':
			extension=".ord";
			break;
		
		case '2':
			extension=".orn";
			break;
		case '3':
			extension=".vip";
			break;		
		}
			
		
		return extension;
	}
	
}

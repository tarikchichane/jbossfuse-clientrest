package org.bam.rest.consumer.processor;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;


public class FileCamelDownloadFile implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		String newFileName = "";
		Map<String, Object> fileMap = exchange.getMessage().getHeaders();
		for (Entry<String, Object> fileEntry : fileMap.entrySet()) {
			String fileName = fileEntry.getKey();
			String extension = fileEntry.getValue().toString();
			newFileName = fileName.replaceAll(".txt", extension);
			try {
				URL url = new URL("http://127.0.0.1:8181/cxf/fileservice/fileset/download/"+fileName);
				URLConnection connection = url.openConnection();
				InputStream in = connection.getInputStream();
				FileOutputStream fos = null;
				File file=null;
				byte[] buffer=new byte[512];
				switch (extension) {
				case ".ord":
					file=new File("C:\\temp\\outbox\\ord\\"+newFileName);
					if(file.exists()) {
						System.out.println("file exist");
						break;
					}
					else {
						file.createNewFile();
					}
					fos=new FileOutputStream(file);
					while (true) {
						 int len = in.read(buffer);
						    if (len == -1) {
						        break;
						    }
						    fos.write(buffer,0,len);
					}
					in.close();
					fos.flush();
					fos.close();
					break;
				case ".orn":
					file=new File("C:\\temp\\outbox\\orn\\"+newFileName);
					if(file.exists()) {
						System.out.println("file exist");
						break;
					}
					else {
						file.createNewFile();
					}
					fos=new FileOutputStream(file);
					while (true) {
						 int len = in.read(buffer);
						    if (len == -1) {
						        break;
						    }
						    fos.write(buffer,0,len);
					}
					in.close();
					fos.flush();
					fos.close();
					break;
				case ".vip":
					file=new File("C:\\temp\\outbox\\vip\\"+newFileName);
					if(file.exists()) {
						System.out.println("file exist");
						break;
					}
					else {
						file.createNewFile();
					}
					fos=new FileOutputStream(file);
					while (true) {
						 int len = in.read(buffer);
						    if (len == -1) {
						        break;
						    }
						    fos.write(buffer,0,len);
					}
					in.close();
					fos.flush();
					fos.close();
					break;

				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}

package com.epam.parcerapp.reporter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Reporter {

private Reporter() {}
	
	public static void report(String text, 
					   String filePath, String command) throws ReporterException {
		if(text == null || filePath == null || command == null) {
			throw new ReporterException("Wrong properties");
		}
		try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filePath, true), "utf-8"))){			
				writer.append("---" + command.toUpperCase() + "---\n\n");
				writer.append(text);
				writer.append("\n\n");
		} catch (IOException e) {
			throw new ReporterException(e);
		}
	}

}

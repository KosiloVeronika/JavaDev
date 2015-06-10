package com.epam.parcerapp.reader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
	private FileReader() {}
	
	public static String read(String filePath) throws ReaderException {
		String text;
		try {
			text = new String(Files.readAllBytes(Paths.get("input.txt")), StandardCharsets.UTF_8);
		} catch (IOException ex) {
			throw new ReaderException("Chek file or file path", ex);
		}
		return text;
	}

}

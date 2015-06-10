package com.epam.parcerapp.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;






import com.epam.parcerapp.entity.Composite;
import com.epam.parcerapp.entity.CompositeType;
import com.epam.parcerapp.parse.Parser;
import com.epam.parcerapp.parse.ParserException;

public class Main {

	public static void main(String[] args) throws ParserException, IOException {
		String text = new String(Files.readAllBytes(Paths.get("input.txt")), StandardCharsets.UTF_8);
		Composite comp = new Composite(CompositeType.TEXT);
		Parser.parseManage(text, comp);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("output.txt"), "utf-8"));
		String revivedText = Parser.revive(comp);
		writer.write(revivedText);
		writer.close();
		System.out.println("done!");
	}

}

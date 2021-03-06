package com.epam.parcerapp.main;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.parcerapp.entity.Composite;
import com.epam.parcerapp.entity.CompositeType;
import com.epam.parcerapp.entity.EntityException;
import com.epam.parcerapp.logic.LogicException;
import com.epam.parcerapp.logic.Sorter;
import com.epam.parcerapp.logic.TextEditor;
import com.epam.parcerapp.logic.WordsCounter;
import com.epam.parcerapp.parse.Parser;
import com.epam.parcerapp.parse.ParserException;
import com.epam.parcerapp.reader.FileReader;
import com.epam.parcerapp.reader.ReaderException;
import com.epam.parcerapp.reporter.Reporter;
import com.epam.parcerapp.reporter.ReporterException;

public class Main {

	private static String propFileName = "config/regex.properties";
	private static final String FILE_PATH = "input.txt";
	private final static Logger LOG = Logger.getLogger(Main.class);
	
	static {
		new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
	}

	public static void main(String[] args) throws ParserException, ReaderException, LogicException, EntityException {
		try {
			Parser.configure(propFileName);
			String text = FileReader.read("FILE_PATH");
			Composite comp = new Composite(CompositeType.TEXT);
			Parser.parseManage(text, comp);
			Reporter.report(Parser.revive(comp), "output.txt", "REVIVE TEXT FROM TREE");
			Reporter.report(TextEditor.deleteWord(comp, 6), "output.txt", "DELETE WORD WITH 6 LETTERS");
			Reporter.report(Sorter.sortWords(comp), "output.txt", "SORT WORDS");
			Reporter.report(WordsCounter.countWords(comp), "output.txt", "SORT SENTENSES");
			System.out.println("done!");
			
		} catch (ParserException | ReporterException e) {
			LOG.error(e);
		}
	}

}

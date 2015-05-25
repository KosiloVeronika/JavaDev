package com.epam.newyeargift.view;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.command.Commands;
import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.logic.LogicException;

public class Reporter {
	private final static Logger LOG = Logger.getLogger(Reporter.class);
	
	public static void report(Commands command, Response response) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("Information.txt", true))) {
			StringBuilder info = new StringBuilder("");
			info.append(command + "\n");
			List<Candy> candies = null;
			int sum;
			switch (command) {
			case CREATE_GIFT: {
				info.append(" Created " + response.getData().toString() + "\n") ;
				break;
			}
			case SORT_BY_WEIGHT: {
				info.append(" Sorted " + response.getData().toString() + "\n");
				break;
			}
			case SHOW_ALL: {
				candies = (List<Candy>) response.getData();
				for(Candy c : candies) {
					info.append(c.toString() + "\n");
				}
				break;
			}
			case FIND_BY_SHUGAR_AMOUNT: {
				candies = (List<Candy>) response.getData();
				for(Candy c : candies) {
					info.append(c.toString() + "\n");
				}
				break;
			}
			case COUNT_WEIGHT: {
				sum = (int) response.getData();
				info.append("general weight: " + sum + "\n");
				break;
			}
			default:
				throw new LogicException("Enum doesn't contain this value.");
			}
			writer.write(info.toString());
		} catch (IOException | LogicException e) {
			LOG.error(e);
		}
	}
}

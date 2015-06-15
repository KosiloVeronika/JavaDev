package com.epam.newyeargift.view;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.newyeargift.bean.Response;
import com.epam.newyeargift.command.Commands;
import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.logic.LogicException;

public class Reporter {
	private final static Logger LOG = Logger.getLogger(Reporter.class);
	
	@SuppressWarnings("unchecked")
	public static void report(Commands command, Response response) throws EntityException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("Information.txt", true))) {
			StringBuilder info = new StringBuilder("");
			info.append(command + "\n");
			List<Candy> candies;
			int sum;
			switch (command) {
			case DOM:
				info.append("	Read with DOM " + response.getData().toString() + "\n") ;
				break;
			case SAX:
				info.append("	Read with SAX " + response.getData().toString() + "\n") ;
				break;
			case STAX:
				info.append("	Read with STAX " + response.getData().toString() + "\n") ;
				break;
			case CREATE_GIFT: 
				info.append("	Created " + response.getData().toString() + "\n") ;
				break;
			case SORT_BY_WEIGHT:
				info.append("	Sorted " + response.getData().toString() + "\n");
				break;
			case SHOW_ALL:
				if(response.getData() instanceof GiftBox) {
					candies =  ((GiftBox) response.getData()).getCandies();
				} else {
					candies =  (List<Candy>) response.getData();
				}
				for(Candy c : candies) {
					info.append("	" + c.toString() + "\n");
				}
				break;
			case FIND_BY_SHUGAR_AMOUNT:
				candies = (ArrayList<Candy>) response.getData();
				for(Candy c : candies) {
					info.append("	" + c.toString() + "\n");
				break;
			}
			case COUNT_WEIGHT: 
				sum = (int) response.getData();
				info.append("	general weight: " + sum + "\n");
				break;
			default:
				throw new LogicException("Enum doesn't contain this value.");
			}
			writer.write(info.toString());
		} catch (IOException | LogicException e) {
			LOG.error(e);
		}
	}
}

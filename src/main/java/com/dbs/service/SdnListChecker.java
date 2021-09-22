package com.dbs.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SdnListChecker {
	public boolean checker(String phrase) throws IOException {
		Scanner fileScanner = new Scanner(
				new File(".\\src\\main\\resources\\sdnlist.txt"));
		int lineID = 0;
		boolean f = true;
//	      String phrase="GRUPO MBS LIMITADA";
		Pattern pattern = Pattern.compile(phrase);
		Matcher matcher = null;
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			lineID++;
			matcher = pattern.matcher(line);
			if (matcher.find()) {
				f = false;

			}

		}
		return f;
	}
}

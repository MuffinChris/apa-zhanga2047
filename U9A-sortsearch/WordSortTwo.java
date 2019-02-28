//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		String[] word2Ray = new String[wordRay.length];
		for (int z = 0; z < wordRay.length; z++) {
			String lowest = "ZZZZZZZ";
			int index = 0;
			for (int i = 0; i < wordRay.length; i++) {
				if (wordRay[i].compareTo(lowest) < 0) {
					lowest = wordRay[i];
					index = i;
				}
			}
			wordRay[index] = "ZZZZZZZZ";
			word2Ray[z] = lowest;
			lowest = "ZZZZZZZ";
			
		}
		wordRay = word2Ray;
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < wordRay.length; i++) {
			output+= " " + wordRay[i]; 
		}
		return output+"\n\n";
	}
}
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] newAr = new int[size];
		for (int i = 0; i < newAr.length; i++) {
			newAr[i] = (int) (Math.random() * 10 + 1);
		}
		return newAr;
	}
	public static void shiftEm(int[] array)
	{
		int[] shifted = new int[array.length];
		int index = 0;
		for (int i : array) {
			if (i == 7) {
				shifted[index] = (i);
				index++;
			}
		}
		
		for (int i : array) {
			if (i != 7) {
				shifted[index] = (i);
				index++;
			}
		}
		for (int i = 0; i < shifted.length; i++) {
			System.out.print(shifted[i] + " ");
		}
	}
}
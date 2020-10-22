package com.huaxia.java2;

import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class PartsRunner {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File("partinfo.dat"));
		PartList list = new PartList();
		ArrayList<Part> arr = new ArrayList<>();
		while (input.hasNext()) {
			String line = input.nextLine();
			String[] s = line.split(" ");
			Part p = new Part(s);
			arr.add(p);

			// list.sortMap();
			// TreeMap<Part, Integer> map =list.sortMap();
			// for(Part q : map.keySet()) {
			// int i= map.get(p);
			// System.out.println(p);

		}
		System.out.println(arr);
		System.out.println();
	}
}
//}

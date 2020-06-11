package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Arry {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < 4; i++) {
			List<Integer> integers = new ArrayList<Integer>();
			for (int j = 0; j < 2; j++) {
				Random random = new Random();
				integers.add(random.nextInt());
			}
			list.add(integers);
		}
		System.out.println(list);

		int[][] array = new int[list.size()][];

		for (int i = 0; i < array.length; i++) {
			array[i] = new int[list.get(i).size()];
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				array[i][j] = list.get(i).get(j);
			}
		}
		System.out.println(Arrays.deepToString(array));

	}

}

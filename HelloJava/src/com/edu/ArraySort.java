package com.edu;

public class ArraySort {
	public static void sorting(int[] ary) {
		int loopCnt = ary.length - 1; // 마지막값이 제일 처음위치로 이동하려면 배열크기 - 1
		for (int cnt = 0; cnt < loopCnt; cnt++) {
			int temp = ary[0]; // 첫번재 값으로 temp값을 지정.
			for (int i = 0; i < loopCnt; i++) {
				if(ary[i] > ary[i + 1]) {
					// 34 25 => 25 34로 위치 변경.
					temp = ary[i];
					ary[i] = ary[i + 1];
					ary[i + 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// int[] intAry => {34, 25, 48, 12}
		// intAry[i] -> intAry[i+1]; // 34 25
		int[] intAry = {34, 25, 48, 12, 8};
		int[] intAry2 = {22, 56, 99, 11};
		int[] intAry3 = {92, 28, 46, 14};
		int[] resultAry = intArrSort(intAry);
		intArrPrinter(resultAry);
		
		sorting(intAry2);
		intArrPrinter(intAry2);
		
		
		System.out.println("\nend of prog");
	}
	
	private static int[] intArrSort(int[] arr) {
		int[] intArr = arr.clone(); // deep copy
		for(int i = 0; i < intArr.length-1; i++) {
			for(int j = i+1; j < intArr.length; j++) {
				int temp = intArr[i];
				if( intArr[i] > intArr[j] ) {
					temp = intArr[j];
					intArr[j] = intArr[i];
					intArr[i] = temp;
				}
			}
		}
		return intArr;
	}
	
	private static int[] yedamSort(int[] intArr) {
		int[] intAry = intArr; //
		int loopCnt = intAry.length - 1; // 마지막값이 제일 처음위치로 이동하려면 배열크기 - 1
		for (int cnt = 0; cnt < loopCnt; cnt++) {
			int temp = intAry[0]; // 첫번재 값으로 temp값을 지정.
			for (int i = 0; i < loopCnt; i++) {
				if(intAry[i] > intAry[i + 1]) {
					// 34 25 => 25 34로 위치 변경.
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
		return intAry;
	}
	
	private static void intArrPrinter(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
}


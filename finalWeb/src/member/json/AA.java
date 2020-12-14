package member.json;

import java.util.Arrays;

public class AA {
public static void main(String[] args) {
	/*
	 * [[0,30],[5,10],[15,20]];
	 * false
	 * 
	 * [[7,10],[2,4]]
	 * true;
	 * 
	 * 
	 * */
//	int[][] a= {{3,2},{1,5}};
//	int[][] a = {{0,30},{5,10},{15,20}};
	int[][] a = {{0,3},{5,10},{15,20},{3,4},{4,5}};
//	int[][] a = {{7,10},{2,4}};
	int max= 0;
	for(int i = 0; i<a.length;i++) {
		for(int j=0; j<2; j++) {
			if(a[i][j]>max) {
				max = a[i][j];
			}
		}
	}
	System.out.println(max);
	
	boolean[] boArr = new boolean[max];
	boolean result = true;
	for(int i=0; i<a.length;i++) {
		Arrays.sort(a[i]);
		for(int j=a[i][0];j<a[i][1];j++) {
			if(boArr[j]==false) {
				boArr[j]=true;
			}
			else {
				result = false;
				break;
			}
		}
		
	}
	System.out.println(result);
}
}

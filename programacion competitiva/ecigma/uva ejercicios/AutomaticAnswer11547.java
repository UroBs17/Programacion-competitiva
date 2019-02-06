package gg;

import java.io.*;
import java.util.*;

public class AutomaticAnswer11547 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int cases=Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++) {
			int n=Integer.parseInt(br.readLine());
			int rta=(int)(((((n*63)+7492)*235)/47)-498);
			rta=(rta/10)%10;
			System.out.println(Math.abs(rta));
		}
	}

}

import java.util.*;
import java.io.*;
public class RandomList {
	private ArrayList<Integer> arr;
	
	public RandomList() {
		arr=new ArrayList<Integer>();
	}
	public void insertOne(int k) {
		arr.add(k);
	}
	public int removeOne() {
		int ind=(int)(arr.size()*Math.random());
		int k=arr.get(ind);
		ArrayList<Integer> p=new ArrayList<Integer>();
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)>0) {
				p.add(arr.get(i));
				p.add(arr.get(i));
			}
		}
		arr.remove(ind);
		arr.addAll(p);
		return k;
	}
	public void print() {
		Collections.sort(arr);
		for(int i=arr.size()-1;i>=0;i--) {
			if(arr.get(i)%2==0)System.out.print(arr.get(i)+" ");
		}
		System.out.println();
		for(int i=arr.size()-1;i>=0;i--) {
			if(arr.get(i)%2==1)System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args)  {
		RandomList rl=new RandomList();
		for(int i=-5;i<6;i++)rl.insertOne(i);
		float cP=0,cN=0;
		for(int i=0;i<100;i++) {
			int num=rl.removeOne();
			//System.out.println(num);
			if(num>0)cP++;
			else cN++;
		}
		System.out.println((float)(cP/(cP+cN))+" "+(float)(cN/(cP+cN)));
	}
}

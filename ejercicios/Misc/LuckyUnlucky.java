import java.util.*;

public class LuckyUnlucky {
	public int count(int[] numbers,int n) {
		Arrays.sort(numbers);
		int upper,lower;
		int i;
		for(i=0;i<numbers.length;i++) {
			if(numbers[i]>n)break;
		}
		//System.out.println(i);
		upper=numbers[i];
		lower=i==0?0:numbers[i-1];
		System.out.println(upper+" "+lower);
		return (n-lower)*(upper-n);//era con formula, sin necesidad de los dos for
	}
	public static void main(String[] args) {
		LuckyUnlucky lul=new LuckyUnlucky();
		int[] nums1= {1,7,4,14,10};
		int[] nums2= {4,8,13,24,30};
		int[] nums3= {10,20,30,40,50};
		int n1=2,n2=10,n3=30;
		System.out.println(lul.count(nums1,n1));
		System.out.println(lul.count(nums2,n2));
		System.out.println(lul.count(nums3,n3));

	}

}

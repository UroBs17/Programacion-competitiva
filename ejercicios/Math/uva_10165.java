import java.util.*;


public class uva_10165 {
	
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
	
		while(true)
		{
			int n = sc.nextInt();
			if(n == 0)
				break;
			int s = 0;
			while(n-->0) s ^= sc.nextInt();
			System.out.println(s == 0 ? "No" : "Yes");
		}
	}
}

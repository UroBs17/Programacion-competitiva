import java.util.*;
public class uva_460 {
	public static void main(String[] args)throws Exception {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
	    while(t-->0) {
	        int ax=sc.nextInt(),ay=sc.nextInt(),bx=sc.nextInt(),by=sc.nextInt();
	        int cx=sc.nextInt(),cy=sc.nextInt(),dx=sc.nextInt(),dy=sc.nextInt();
	        int lbx = Math.max(ax, cx);
	        int lby = Math.max(ay, cy);
	        int ubx = Math.min(bx, dx);
	        int uby = Math.min(by, dy);
	        if(lbx >= ubx || lby >= uby) System.out.println("No Overlap");
	        else System.out.println(lbx+" "+lby+" "+ubx+" "+uby);
	        if(t>0)System.out.println();
	    }
	}
}

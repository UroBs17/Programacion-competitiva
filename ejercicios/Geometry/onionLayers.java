import java.util.*;
import java.io.*;
public class onionLayers {
	private static class Point implements Comparable<Point>{
        private int x, y, ind;
        public Point(int x, int y,int ind) {
            this.x = x;
            this.y = y;
            this.ind = ind;
        }
		@Override
		public int compareTo(Point other) {
			if (x != other.x)return Double.compare(x, other.x);
			else return Double.compare(y, other.y);
    	}
    }
	public static int cross(Point q,Point r,Point p) {
		return (q.x - r.x) * (p.y - r.y)-(q.y - r.y) * (p.x - r.x);
	}
	public static List<Point>  getConvexHull(List<Point> points){
		List<Point> uH = new ArrayList<>();
		Collections.sort(points);
		for (Point p : points) {
			while (uH.size() >= 2) {
				Point q = uH.get(uH.size() - 1);
				Point r = uH.get(uH.size() - 2);
				if (cross(q,r,p) > 0)uH.remove(uH.size() - 1);//c(q,r,p)=0 collinear
				else break;
			}
			uH.add(p);
		}
		uH.remove(uH.size() - 1);
		List<Point> lH = new ArrayList<>();
		for (int i = points.size() - 1; i >= 0; i--) {
			Point p = points.get(i);
			while (lH.size() >= 2) {
				Point q = lH.get(lH.size() - 1);
				Point r = lH.get(lH.size() - 2);
				if (cross(q,r,p) > 0)lH.remove(lH.size() - 1);//c(q,r,p)=0 collinear
				else break;
			}
			lH.add(p);
		}
		lH.remove(lH.size() - 1);
		if (!(uH.size() == 1 && uH.equals(lH)))	uH.addAll(lH);
		return uH;
	}
    public static void main(String[] args) throws Exception{
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		int n=Integer.parseInt(br.readLine());
    		if (n==0)break;
    		List<Point> points=new ArrayList<Point>();
    		for(int i=0;i<n;i++) {
    			StringTokenizer stk=new StringTokenizer(br.readLine());
    			int x=Integer.parseInt(stk.nextToken()),y=Integer.parseInt(stk.nextToken());
    			points.add(new Point(x,y,i));
    		}
    		boolean[] vi=new boolean[points.size()];
    		int c=0;
    		while(points.size()>0) {
    			List<Point> hull = getConvexHull(points);
    			c++;
    			ArrayList<Point> p=new ArrayList<Point>();
    			for(Point pi:hull)vi[pi.ind]=true;
    			for(Point pk:points)if (!vi[pk.ind])p.add(pk);
    			points=p;
    		}
    		if(c%2==1)System.out.println("Take this onion to the lab!");
    		else System.out.println("Do not take this onion to the lab!");
    	}
    }
}
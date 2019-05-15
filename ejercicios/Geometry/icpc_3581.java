import java.io.*;
import java.util.*;
public class icpc_3581 {
	private static class Point implements Comparable<Point>{
        private int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
		@Override
		public int compareTo(Point other) {
			if (x != other.x)return Double.compare(x, other.x);
			else return Double.compare(y, other.y);
    	}
		public boolean equals(Point sh) {
			return x==sh.x && y==sh.y;
		}
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
	public static boolean isInPolygon(Point p,List<Point> polygon){
		int pos = 0, neg = 0;
	    for (int i = 0; i < polygon.size(); i++){
	        if (polygon.get(i).equals(p)) return true;
	        int i2 = i < polygon.size() - 1 ? i + 1 : 0;
	        int d = cross(p,polygon.get(i),polygon.get(i2));
	        if (d > 0) pos++;
	        if (d < 0) neg++;
	        if (pos > 0 && neg > 0)return false;
	    }
	    return true;
	}
	public static boolean point_in_box(int x, int y, int x0, int y0, int x1, int y1) {
		return Math.min(x0, x1) <= x && x <= Math.max(x0, x1) &&   Math.min(y0, y1) <= y && y <= Math.max(y0, y1);
	}
	public static int cross(Point q,Point r,Point p) {
		return (q.x - r.x) * (p.y - r.y)-(q.y - r.y) * (p.x - r.x);
	}

	public static boolean hit(Point p1,Point p2,Point q1,Point q2) {
		int d1=cross(p1,q1,q2);
		int d2=cross(p2,q1,q2);
		int d3=cross(q1,p1,p2);
		int d4=cross(q2,p1,p2);
		boolean b1 = (d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0);
		boolean b2 = (d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0);
		if (b1 && b2) return true;
		if (d1 == 0 && point_in_box(p1.x, p1.y, q1.x, q1.y, q2.x, q2.y)) return true;
		if (d2 == 0 && point_in_box(p2.x, p2.y, q1.x, q1.y, q2.x, q2.y)) return true;
		if (d3 == 0 && point_in_box(q1.x, q1.y, p1.x, p1.y, p2.x, p2.y)) return true;
		if (d4 == 0 && point_in_box(q2.x, q2.y, p1.x, p1.y, p2.x, p2.y)) return true;			
		return false;
	}
	public static boolean intersect(List<Point> penguins,List<Point> doors) {
		List<Point> hDoors=getConvexHull(doors);
		List<Point> hPenguins=getConvexHull(penguins);
		for (int i = 0; i + 1 < hDoors.size(); ++i) {
			for (int j = 0; j + 1 < hPenguins.size(); ++j) {
				Point p1 = hDoors.get(i), p2 = hDoors.get(i + 1);
				Point q1 = hPenguins.get(j), q2 = hPenguins.get(j + 1);
				if (hit(p1, p2,q1, q2))return true;
			}
		}
		for(Point pt:penguins) {
			if(isInPolygon(pt,hDoors))return true;
		}
		for(Point pt:doors) {
			if(isInPolygon(pt,hPenguins))return true;
		}
		return false;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int c=1;
		while(true) {
			StringTokenizer stk=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(stk.nextToken()),p=Integer.parseInt(stk.nextToken());
			if(d+p==0) break;
			if(c>1)System.out.println();
			ArrayList<Point> doors=new ArrayList<Point>();
			ArrayList<Point> penguins=new ArrayList<Point>();
			for(int i=0;i<d;i++) {
				stk=new StringTokenizer(br.readLine());
				int x1=Integer.parseInt(stk.nextToken());
				int y1=Integer.parseInt(stk.nextToken());
				int x2=Integer.parseInt(stk.nextToken());
				int y2=Integer.parseInt(stk.nextToken());
				doors.add(new Point(x1,y1));
				doors.add(new Point(x1,y2));
				doors.add(new Point(x2,y1));
				doors.add(new Point(x2,y2));
			}
			for(int i=0;i<p;i++) {
				stk=new StringTokenizer(br.readLine());
				int x1=Integer.parseInt(stk.nextToken());
				int y1=Integer.parseInt(stk.nextToken());
				int x2=Integer.parseInt(stk.nextToken());
				int y2=Integer.parseInt(stk.nextToken());
				penguins.add(new Point(x1,y1));
				penguins.add(new Point(x1,y2));
				penguins.add(new Point(x2,y1));
				penguins.add(new Point(x2,y2));
			}
			System.out.println("Case "+c+": It is"+(intersect(penguins,doors)?" not":"")+" possible to separate the two groups of vendors.");
			c++;
		}
	}
}

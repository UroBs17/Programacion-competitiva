import java.util.*;
import java.io.*;
public class uva_11665 {
	private static class Point{
        private int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean equals(Point sh) {
			return x==sh.x && y==sh.y;
		}
        public String toString() {
        	return x+" "+y;
        }
    }
	public static int[] p;
	
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
	public static boolean intersect(List<Point> polygon1,List<Point> polygon2) {
		
		for(Point pt:polygon1) {
			if(isInPolygon(pt,polygon2))return true;
		}
		for(Point pt:polygon2) {
			if(isInPolygon(pt,polygon1))return true;
		}
		for (int i = 0; i < polygon2.size(); i++) {
			for (int j = 0; j < polygon1.size(); j++) {
				Point p1 = polygon2.get(i), p2 = polygon2.get((i + 1)%polygon2.size());
				Point q1 = polygon1.get(j), q2 = polygon1.get((j + 1)%polygon1.size());
				if (hit(p1, p2,q1, q2))return true;
			}
		}
		return false;
	}

	public static int find(int u) {
		return p[u] == u ? u :( p[u] = find(p[u]));
	}

	public static void link(int u, int v) {
	    if (find(u) != find(v)) {
	        p[find(u)] = find(v);
	    }
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		while(true) {
			int n=Integer.parseInt(br.readLine());
			if(n==0)break;
			ArrayList<ArrayList<Point>>polygons=new ArrayList<ArrayList<Point>>();
			p=new int[n];
			for(int i=0;i<n;i++) {
				ArrayList<Point> points=new ArrayList<Point>();
				StringTokenizer stk=new StringTokenizer(br.readLine());
				while(stk.hasMoreTokens()) {
					points.add(new Point(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())));
				}
				polygons.add(points);
			}
			for (int i = 0; i < n; ++i) {
		        p[i] = i;
		    }
			for(int i=0;i<n-1;i++) {
				for(int j=i+1;j<n;j++) {
					if(intersect(polygons.get(i),polygons.get(j))) {
						link(i,j);
						/*System.out.println("----------");
						System.out.println(polygons.get(i));
						System.out.println(polygons.get(j));
						System.out.println(i+" "+j);
						System.out.println("----------");*/
					}
				}
			}
			Set<Integer> ans=new HashSet<Integer>();
		    for (int i = 0; i < n; i++) {
		        ans.add(find(i));
		    }
		    System.out.println(ans.size());
		}
	}
}

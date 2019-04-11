import java.util.*;
import java.io.*;
public class onionLayers {
	private static class Point{
        private int x, y, ind;
        public Point(int x, int y,int ind) {
            this.x = x;
            this.y = y;
            this.ind = ind;
        }
    }
    public static List<Point> getConvexHull(List<Point> points) {
        List<Point> sorted = new ArrayList<Point>(getSortedPointSet(points));
        Stack<Point> stack = new Stack<Point>();
        stack.push(sorted.get(0));
        stack.push(sorted.get(1));
        for (int i = 2; i < sorted.size(); i++) {
            Point head = sorted.get(i);
            Point middle = stack.pop();
            Point tail = stack.peek();
            long crossProduct = (middle.x - tail.x) * (head.y - tail.y) - (middle.y - tail.y) * (head.x - tail.x);
			if(crossProduct > 0) {
                stack.push(middle);
                stack.push(head);
			}
			else if(crossProduct < 0) {
				i--;
			}
			else {
				stack.push(head);
			}
        }
        stack.push(sorted.get(0));
        return new ArrayList<Point>(stack);
    }
    protected static Point getLowestPoint(List<Point> points) {
        Point lowest = points.get(0);
        for(int i = 1; i < points.size(); i++) {
            Point temp = points.get(i);
            if(temp.y < lowest.y || (temp.y == lowest.y && temp.x < lowest.x)) {
                lowest = temp;
            }
        }
        return lowest;
    }
    protected static Set<Point> getSortedPointSet(List<Point> points) {
        final Point lowest = getLowestPoint(points);
        TreeSet<Point> set = new TreeSet<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if(a == b || a.equals(b)) return 0;
                double thetaA = Math.atan2((long)a.y - lowest.y, (long)a.x - lowest.x);
                double thetaB = Math.atan2((long)b.y - lowest.y, (long)b.x - lowest.x);
                if(thetaA < thetaB) {
                    return -1;
                }
                else if(thetaA > thetaB) {
                    return 1;
                }
                else {
                    double distanceA = Math.sqrt((((long)lowest.x - a.x) * ((long)lowest.x - a.x)) +
                                                (((long)lowest.y - a.y) * ((long)lowest.y - a.y)));
                    double distanceB = Math.sqrt((((long)lowest.x - b.x) * ((long)lowest.x - b.x)) +
                                                (((long)lowest.y - b.y) * ((long)lowest.y - b.y)));

                    if(distanceA < distanceB) return -1;
                    else return 1;
                }
            }
        });
        set.addAll(points);
        return set;
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
    		while(n>0) {
    			List<Point> hull = getConvexHull(points);
    			ArrayList<Point> p=new ArrayList<Point>();
    			ArrayList<Integer> intk=new ArrayList<Integer>();
    			for(Point pi:hull) {
    				
    			}
    			n-=hull.size();
    		}
    		
    		
    	}
    }
}

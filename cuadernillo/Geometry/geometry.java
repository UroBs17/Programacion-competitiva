//AreaOfAnyPolygon = 1/2 * Σ (From i=0 to n-1) Xi * Yi+1 - Xi+1 + Yi
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

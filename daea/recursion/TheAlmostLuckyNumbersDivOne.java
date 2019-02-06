
 
public class TheAlmostLuckyNumbersDivOne {
  public long find(long a, long b) {
        return iterate(a, b, 0, true);
  }
 
    private long iterate(long a, long b, long cur, boolean canBad) {
        if (cur > b) return 0;
        long res =  0;
        if (cur >= a) ++res;
        res += iterate(a, b, cur * 10 + 4, canBad);
        res += iterate(a, b, cur * 10 + 7, canBad);
        if (canBad) {
            for (int i = 0; i < 10; ++i) {
                if (i == 0 && cur == 0) continue;
                if (i == 4 || i == 7) continue;
                res += iterate(a, b, cur * 10 + i, false);
            }
        }
        return res;
    }
 
}
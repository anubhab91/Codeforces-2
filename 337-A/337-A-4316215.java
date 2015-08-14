import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000007;
    static ArrayList<Integer>[] g;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  
  int m = input.nextInt(), n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  Arrays.sort(data);
  int res = 987654321;
  for(int i = 0; i<n -m+1; i++)
      res = Math.min(res, data[i+m-1]-data[i]);
  out.println(res);
  
  out.close();
}
/*
 * Convex Hull Trick - Maintains a set of lines and tells for a given query x, which line has lowest y-value.
 * Insertion and query are both O(log(n)).  It assumes that they are entered in order of decreasing slope.
 */
public static Segment[] stk;
public static int size;
public static void insert(long m, long b)
{
    Segment toAdd = new Segment(m, b);
    while(size >= 2)
    {
        double last = stk[size].intersect(stk[size-1]);
        double cur = toAdd.intersect(stk[size-1]);
        if(cur < last) size--;
        else break;
    }
    stk[++size] = toAdd;
}
public static long query(long x)
{
    int lo = 1, hi = size+1;
    while(hi>lo+1)
    {
        int mid = (hi+lo)/2;
        double left = mid == 1 ? 0 : stk[mid].intersect(stk[mid-1]);
        double right = mid == size ? 1987654321 : stk[mid].intersect(stk[mid+1]);
        if(left < x && right > x) return stk[mid].eval(x);
        else if(left > x) hi = mid;
        else lo = mid;
    }
    return stk[lo].eval(x);
}
public static class Segment
{
    long m, b;
    public Segment(long m, long b)
    {
        this.m = m;
        this.b = b;
    }
    public long eval(long x)
    {
        return m*x+b;
    }
    public double intersect(Segment o)
    {
        return 1.*(o.b-b)/(m-o.m);
    }
}
static class input {
  static BufferedReader reader;
  static StringTokenizer tokenizer;

  /** call this method to initialize reader for InputStream */
  static void init(InputStream input) {
      reader = new BufferedReader(
                   new InputStreamReader(input) );
      tokenizer = new StringTokenizer("");
  }

  /** get next word */
  static String next() throws IOException {
      while ( ! tokenizer.hasMoreTokens() ) {
          //TODO add check for eof if necessary
          tokenizer = new StringTokenizer(
                 reader.readLine() );
      }
      return tokenizer.nextToken();
  }

  static int nextInt() throws IOException {
      return Integer.parseInt( next() );
  }
  
  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static long nextLong() throws IOException {
      return Long.parseLong( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}
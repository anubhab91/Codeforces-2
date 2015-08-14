import java.util.*;
import java.io.*;
public class a {
    static long mod = 1000000009;
    static ArrayList<Integer>[] tree;
    static long[] data;
public static void main(String[] args) throws IOException
{
    //Scanner input = new Scanner(new File("input.txt"));
    //PrintWriter out = new PrintWriter(new File("output.txt"));
  input.init(System.in);
  PrintWriter out  = new PrintWriter((System.out));
  int n = input.nextInt();
  ArrayList<Integer>[] g = new ArrayList[n];
  for(int i = 0; i<n; i++) g[i] = new ArrayList<Integer>();
  for(int i = 0; i<n-1; i++)
  {
      int a = input.nextInt()-1, b = input.nextInt()-1;
      g[a].add(b);
      g[b].add(a);
  }
  tree = new ArrayList[n];
  for(int i = 0; i<n; i++) tree[i] = new ArrayList<Integer>();
  boolean[] visited = new boolean[n];
  Queue<Integer> q = new LinkedList<Integer>();
  visited[0] = true;
  q.add(0);
  while(!q.isEmpty())
  {
      int at = q.poll();
      for(int x: g[at])
          if(!visited[x])
          {
              tree[at].add(x);
              visited[x] = true;
              q.add(x);
          }
  }
  data = new long[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  long[] res = go(0);
  out.println(res[1]+res[0]);
  out.close();
}
static long[] go(int at)
{
    long a = 0, b = 0;
    for(int x: tree[at])
    {
        long[] xx = go(x);
        a = Math.max(a, xx[0]);
        b = Math.max(b, xx[1]);
    }
    data[at] = data[at]+b-a;
    return new long[]{a+Math.max(0,data[at]), b-Math.min(0, data[at])};
}
static long pow(long x, long p)
{
    if(p==0) return 1;
    if((p&1) > 0)
    {
        return (x*pow(x, p-1))%mod;
    }
    long sqrt = pow(x, p/2);
    return (sqrt*sqrt)%mod;
}
static long gcd(long a, long b)
{
    if(b==0) return a;
    return gcd(b, a%b);
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
/*
Sum Interval Tree - uses O(n) space
Updates and queries over a range of values in log(n) time
Note: If querying all elements, use difference array instead.
*/
static class IT
{
    int[] left,right, val, a, b;
    IT(int n)
    {
        left = new int[4*n];
        right = new int[4*n];
        val = new int[4*n];
        a = new int[4*n];
        b = new int[4*n];
        init(0,0, n);
    }
    int init(int at, int l, int r)
    {
        a[at] = l;
        b[at] = r;
        if(l==r)
            left[at] = right [at] = -1;
        else 
        {
            int mid = (l+r)/2;
            left[at] = init(2*at+1,l,mid);
            right[at] = init(2*at+2,mid+1,r);
        }
        return at++;
    }
    //return the sum over [x,y]
    int get(int x, int y)
    {
        return go(x,y, 0);
    }
    int go(int x,int y, int at)
    {
        if(at==-1) return 0;
        if(x <= a[at] && y>= b[at]) return val[at];
        if(y<a[at] || x>b[at]) return 0;
        return go(x, y, left[at]) + go(x, y, right[at]);
    }
    //add v to elements x through y
    void add(int x, int y, int v)
    {
        go3(x, y, v, 0);
    }
    void go3(int x, int y, int v, int at)
    {
        if(at==-1) return;
        if(y < a[at] || x > b[at]) return;
        val[at] += (Math.min(b[at], y) - Math.max(a[at], x) + 1)*v;
        go3(x, y, v, left[at]);
        go3(x, y, v, right[at]);
    }
}
}
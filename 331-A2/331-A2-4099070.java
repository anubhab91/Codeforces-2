import java.util.*;
import java.io.*;
public class a {
  static long mod  = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  int[] data = new int[n];
  for(int i = 0; i<n; i++) data[i] = input.nextInt();
  HashMap<Integer, Integer> last = new HashMap<Integer,Integer>();
  for(int i = 0; i<n; i++) last.put(data[i], i);
  long[] sums = new long[n];
  sums[0] = data[0] > 0 ? data[0] : 0;
  for(int i = 1; i<n; i++) sums[i] = data[i] >= 0 ? data[i]+sums[i-1]:sums[i-1];
  long max = (long)(-2e9-2);
  int a = -1, b = -1;
  for(int i = 0; i<n; i++)
  {
    int l = last.get(data[i]);
    if(l==i) continue;
    long sum = sums[l] - (i==0 ? 0:sums[i-1]);
    if(data[i] < 0) sum += 2*data[i];
    if(sum > max)
    {
      max = sum;
      a = i; b = l;
    }
  }
  ArrayList<Integer> cut = new ArrayList<Integer>();
  for(int i = 0; i<a; i++) cut.add(i+1);
  for(int i = a+1; i<b; i++) if(data[i] < 0) cut.add(i+1);
  for(int i = b+1; i<n; i++) cut.add(i+1);
  out.println(max+" "+cut.size());
  for(int x: cut) out.print(x+" ");

  out.close();
}
static class Person implements Comparable<Person>
{
  String name;
  int h;
  public Person(String n, int hh)
  {
    name = n;
    h = hh;
  }
  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Person o) {
    // TODO(mkirsche): Auto-generated method stub
    return this.h - o.h;
  }
}
static long[][] comb(int n)
{
  long[][] res = new long[n+1][n+1];
  Arrays.fill(res[0], 0);
  for(int i = 0; i<=n; i++) res[i][0] = 1;
  for(int i = 1; i<=n; i++)
    for(int j = 1; j<=n; j++)
      res[i][j] = (res[i-1][j-1] + res[i-1][j])%mod;
  return res;
}
static long gcd(long a, long b)
{
  if(b==0) return a;
  return gcd(b, a%b);
}
static long pow(long a, long p)
{
  if(p<=0) return 1;
  if((p&1) == 0)
  {
    long sqrt = pow(a, p/2);
    return (sqrt*sqrt)%mod;
  }
  else
    return (a*pow(a,p-1))%mod;
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
  public static boolean hasNext() {
    // TODO(mkirsche): Auto-generated method stub
    return tokenizer.hasMoreTokens();
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
  static long nextLong() throws IOException {
    return Long.parseLong( next() );
}

  static double nextDouble() throws IOException {
      return Double.parseDouble( next() );
  }
  static String nextLine() throws IOException {
    return reader.readLine();
  }
}
}
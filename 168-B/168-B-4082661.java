import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  //input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  Scanner input = new Scanner(System.in);
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  boolean amp = true;
  int count = 0;
  while(input.hasNextLine())
  {
    count++;
    String s = input.nextLine();
    boolean a = false;
    for(int i = 0; i<s.length(); i++)
    {
      if(s.charAt(i) != ' ')
      {
        if(s.charAt(i) == '#')
        {
          a = true;
        }
        break;
      }
    }
    if(a)
    {
      if(amp) out.print(count > 1 ?'\n'+s:s);
      else
      {
        amp = true;
        out.print('\n'+s);
      }
    }
    else
    {
      if(amp)
      {
        if(count>1)out.print('\n');
        amp = false;
      }
      for(int i = 0; i<s.length(); i++)
        if(s.charAt(i) != ' ')
          out.print(s.charAt(i));
    }
  }
  out.print('\n');
  out.close();
}
static int depth(int[] parent, int x)
{
  int res = 0;
  for(int i = 0; i<parent.length; i++)
  {
    if(parent[i] == x)
      res = Math.max(res, 1+depth(parent, i));
  }
  return res;
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

  /**
   * @return
   */
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
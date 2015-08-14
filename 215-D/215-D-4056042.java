import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //input.init(new FileInputStream(new File("input.txt")));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt(), m = input.nextInt();
  int[] ts = new int[n], maxt = new int[n], comp = new int[n], cost = new int[n];
  for(int i = 0; i<n; i++)
  {
    ts[i] = input.nextInt();
    maxt[i] = input.nextInt();
    comp[i] = input.nextInt();
    cost[i] = input.nextInt();
  }
  long res = 0;
  for(int i = 0; i<n; i++)
  {
    if(ts[i] >= maxt[i])
    {
      res += (long)comp[i]*m + cost[i];
    }
    else
    {
      int diff = (maxt[i]-ts[i]);
      int needed = (m+diff-1)/diff;
      res += Math.min((long)needed*cost[i], cost[i] + (long)comp[i]*m);
    }
  }
  out.println(res);


  out.close();
}
static long pow(long a, long p)
{
  if(p==0) return 1;
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
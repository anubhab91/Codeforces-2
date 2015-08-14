import java.util.*;
import java.io.*;
public class a {
  static long mod = 1000000007;
  static boolean[][] blacks;
public static void main(String[] args) throws IOException
{
  input.init(System.in);
  PrintWriter out = new PrintWriter(new PrintStream(System.out));
  //Scanner input = new Scanner(new File("input.txt"));
  //PrintWriter out = new PrintWriter(new File("output.txt"));
  int n = input.nextInt();
  int[][] adj = new int[n][n];
  for(int i = 0; i<n; i++) for(int j = 0; j<n; j++) adj[i][j] = input.nextInt();
  int[] delete = new int[n];
  for(int i = 0; i<n; i++) delete[i] = input.nextInt();
  String ans = "";
  for(int k = n-1; k>=0; k--)
  {
    for(int i = 0; i<n; i++)
      for(int j = 0; j<n; j++)
        adj[i][j] = Math.min(adj[i][j], adj[i][delete[k]-1] + adj[delete[k]-1][j]);
    long res = 0;
    for(int i = n-1; i>=k; i--)
      for(int j = n-1; j>=k; j--)
        res += adj[delete[i]-1][delete[j]-1];
    ans = res + " "+ans;
  }
  out.println(ans);

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
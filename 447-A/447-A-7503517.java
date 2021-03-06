import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int p = input.nextInt(), n = input.nextInt();
    int[] data = new int[n];
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    boolean[] used = new boolean[p];
    int res = -1;
    for(int i = 0; i<n && res == -1; i++)
    {
        if(used[data[i]%p]) res = i+1;
        else used[data[i]%p] = true;
    }
    System.out.println(res);
}
public static class input {
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
}
}
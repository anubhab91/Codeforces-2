import java.util.*;
import java.io.*;
public class c {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    int n = input.nextInt();
    int[] data = new int[n];
    ArrayList<Integer> pairs = new ArrayList<Integer>();
    for(int i = 0; i<n; i++) data[i] = input.nextInt();
    Arrays.sort(data);
    for(int i = n-1; i>=1; i--)
    {
        if(data[i] != data[i-1]) data[i]--;
        if(data[i] == data[i-1])
        {
            pairs.add(data[i]);
            i--;
        }
    }
    long res = 0;
    for(int i = 1; i<pairs.size(); i+=2)
    {
        res += (long)pairs.get(i) * pairs.get(i-1);
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
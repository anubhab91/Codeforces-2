import java.util.*;
import java.io.*;
public class a {
public static void main(String[] args) throws IOException
{
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), k = input.nextInt();
    data = new ArrayList<String>();
    for(int i =0; i<n; i++) data.add(input.next());
    out.println(go(new int[k], new boolean[k], 0));
    out.close();
}
static ArrayList<String> data;
static int go(int[] numbers, boolean[] used, int at)
{
    int n = numbers.length;
    if(at == n)
    {
        //process
        //System.out.println(Arrays.toString(numbers));
        int[] nums = new int[data.size()];
        int cur = 0;
        for(int i = 0; i<data.size(); i++)
        {
            String s = "";
            for(int j= 0; j<n;j++) s += data.get(i).charAt(numbers[j]);
            nums[cur++] = Integer.parseInt(s);
        }
        Arrays.sort(nums);
        return nums[nums.length-1] - nums[0];
    }
    int res = 987654321;
    for(int i = 0; i<n; i++)
    {
        if(!used[i])
        {
            used[i] = true;
            numbers[at] = i;
            res = Math.min(res, go(numbers, used, at+1));
            used[i] = false;
        }
    }
    return res;
}
static int gcd(int a, int b)
{
    if(b==0) return a;
    return gcd(b, a%b);
}
static class Soldier implements Comparable<Soldier> {
    int b, i;
    public Soldier(int bb, int ii)
    {
        b = bb; i = ii;
    }
    @Override
    public int compareTo(Soldier that) {
        // TODO Auto-generated method stub
        return that.b - this.b;
    }
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
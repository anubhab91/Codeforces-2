import java.util.*;
import java.io.*;
public class watermelon
{
public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
int weight = input.nextInt();
if(weight%2==0 && weight>=4)
System.out.println("YES");
else
System.out.println("NO");
}
}
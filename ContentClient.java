import java.net.*;
import java.io.*;
public class ContentClient
{
public static void main(String args[]) throws IOException
{
Socket sock=new Socket("172.16.0.162",4000);
System.out.println("enter the filename");
BufferedReader reader= new BufferedReader(new
InputStreamReader(System.in));
String fname=reader.readLine();
OutputStream ostream=sock.getOutputStream();
PrintWriter pwriter=new PrintWriter(ostream,true);
pwriter.println(fname);
InputStream istream=sock.getInputStream();
BufferedReader toread=new BufferedReader(new InputStreamReader
(istream));
String str;
while((str=toread.readLine())!=null)
{
System.out.println(str);
}
pwriter.close();
sock.close();
toread.close();
}
}

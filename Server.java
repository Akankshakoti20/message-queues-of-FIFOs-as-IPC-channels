import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server{
public static void main(String[] args) throws
IOException,FileNotFoundException{
ServerSocket serversocket=new ServerSocket(4000);
System.out.println("Server ready for the connection");
Socket sock=serversocket.accept();
System.out.println("Connection was successful");
InputStream istream=sock.getInputStream();
BufferedReader bufferedReader=new BufferedReader(new
InputStreamReader(istream));
String fname=bufferedReader.readLine();
BufferedReader contentReader=new BufferedReader(new
FileReader(fname));
OutputStream ostream=sock.getOutputStream();
PrintWriter pwrite=new PrintWriter(ostream,true);
String str;
while((str=contentReader.readLine())!=null){
pwrite.println(str);
}
System.out.println("File content sent successful");
sock.close();serversocket.close();pwrite.close();bufferedReader.close
();contentReader.close();
}
}
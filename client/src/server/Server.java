package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    
    // PORT number
    public static final int PORT = 10010;

   public static void main(String[] args) throws IOException {
       
       ServerSocket sSocket = new ServerSocket(PORT);
       System.out.println("start");
       try{
           System.out.println("wait...");
           Socket s = sSocket.accept();
           System.out.println("Connected");
       
           try (InputStream in = s.getInputStream();
                   BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                   BufferedWriter writer = new BufferedWriter(new FileWriter("log.csv"));
                   PrintWriter pw = new PrintWriter(writer)){
               
               String str;
               while((str = reader.readLine()) != null){
                   pw.print(str);
               }
               
               pw.close();
               
               System.out.println("completion");
           }catch(Exception e){
               e.printStackTrace();
           }
        
        } catch (Exception e) {
            e.printStackTrace();
        } 
        sSocket.close();
   }
}

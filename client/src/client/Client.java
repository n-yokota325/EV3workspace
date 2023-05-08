package client;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import lejos.hardware.lcd.LCD;

public class Client {
   public static void main(String[] args) throws Exception {
       LCD.clear();
       LCD.drawString("start", 0, 0);

       Socket s = new Socket("10.00.01.02", 10010);
       LCD.drawString("Connected", 0, 1);
       
       // クライアントソケットの生成
       try (InputStreamReader ir = new InputStreamReader(new FileInputStream("log.csv"))){
           
           
           int ch;
           OutputStream os = s.getOutputStream();
           while ((ch = ir.read()) != -1) {
            os.write(ch);
           }
           os.write(0);
           
           LCD.drawString("completion", 0, 2);
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       s.close();
   }
}
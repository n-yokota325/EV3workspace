package ev3_02_calc;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Ev3Calc {

    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int c = a + b;
        
        String str = "c : " + c;
        LCD.drawString(str, 0, 1);
        LCD.drawString("c : " + c, 0, 2);
        LCD.drawString("c : " + (a + b), 0, 3);
        Delay.msDelay(5000);
    }

}

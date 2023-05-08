package ev3_07_array;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class Ev3Array {

    public static void main(String[] args) {
        String val[] = {"e", "v", "3"};
        
        // âÊñ Ç…Åuev3ÅvÇ∆ï\é¶Ç∑ÇÈ
        LCD.drawString(val[0], 0, 1);
        LCD.drawString(val[1], 0, 2);
        LCD.drawString(val[2], 0, 3);
        Delay.msDelay(3000);

    }

}

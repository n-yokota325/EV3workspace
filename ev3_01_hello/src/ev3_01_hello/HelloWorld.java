package ev3_01_hello;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class HelloWorld {

    public static void main(String[] args) {
        // 画面に「Hello World!」と表示する
        LCD.drawString("Hello World!", 0, 3);
        Delay.msDelay(3000);

    }

}

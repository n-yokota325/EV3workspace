package ev3_06_meandering;

import lejos.hardware.port.MotorPort;

public class Ev3Meandering {
    
    // ƒ^ƒ“ƒN‚ğì¬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
        int i = 0;

        while(i < 3){
            tank.moveFwdForMs(300, 500, 1000);
            tank.moveFwdForMs(500, 300, 1000);
            
            i++;
        }
    }

}

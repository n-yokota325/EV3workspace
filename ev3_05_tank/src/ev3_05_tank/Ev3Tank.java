package ev3_05_tank;

import lejos.hardware.port.MotorPort;

public class Ev3Tank {
    
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
//        // 3ïbä‘ëOêi
//        tank.moveFwd(500, 500);  
//        Delay.msDelay(3000);
//        tank.stop(true, true);
        
        tank.moveFwdForMs(500, 500, 3000);
//        
//        // 2ïbä‘å„ëﬁ
//        tank.moveBwd(500, 500);
//        Delay.msDelay(2000);
//        tank.stop(true, true);
        
        tank.moveBwdForMs(500, 500, 2000);
    }

}

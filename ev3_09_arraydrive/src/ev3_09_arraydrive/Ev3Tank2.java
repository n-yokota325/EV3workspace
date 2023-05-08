package ev3_09_arraydrive;

import lejos.hardware.port.MotorPort;

public class Ev3Tank2 {
    
    // タンクを作成
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
        // 前進
        tank.moveForMs(500, 500, 3000);
        // 後退
        tank.moveForMs(-200, -200, 5000);
        // その場で左回りに旋回
        tank.moveForMs(-500, 500, 3000);
    }
}

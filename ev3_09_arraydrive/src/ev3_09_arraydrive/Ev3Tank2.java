package ev3_09_arraydrive;

import lejos.hardware.port.MotorPort;

public class Ev3Tank2 {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
        // �O�i
        tank.moveForMs(500, 500, 3000);
        // ���
        tank.moveForMs(-200, -200, 5000);
        // ���̏�ō����ɐ���
        tank.moveForMs(-500, 500, 3000);
    }
}

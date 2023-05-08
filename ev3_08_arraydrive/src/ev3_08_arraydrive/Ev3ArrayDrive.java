package ev3_08_arraydrive;

import lejos.hardware.port.MotorPort;

public class Ev3ArrayDrive {
    
    // �^���N���쐬
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
        int lSpeed[] = {300, 0, 500};       // ���X�s�[�h
        int rSpeed[] = {300, 300, 500};     // �E�X�s�[�h
        long time[] = {5000, 3000, 2000};   // ���ԁi�~���b�j

        for (int i = 0; i < time.length; i++) {
            tank.moveFwdForMs(lSpeed[i], rSpeed[i], time[i]);
        }
    }

}

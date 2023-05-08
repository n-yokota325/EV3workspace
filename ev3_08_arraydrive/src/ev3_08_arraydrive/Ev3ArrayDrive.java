package ev3_08_arraydrive;

import lejos.hardware.port.MotorPort;

public class Ev3ArrayDrive {
    
    // タンクを作成
    static Tank tank = new Tank(MotorPort.B, MotorPort.C);

    public static void main(String[] args) {
        int lSpeed[] = {300, 0, 500};       // 左スピード
        int rSpeed[] = {300, 300, 500};     // 右スピード
        long time[] = {5000, 3000, 2000};   // 時間（ミリ秒）

        for (int i = 0; i < time.length; i++) {
            tank.moveFwdForMs(lSpeed[i], rSpeed[i], time[i]);
        }
    }

}

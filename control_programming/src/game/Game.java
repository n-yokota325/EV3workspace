package game;

import body.control.Wheel;
import body.measure.Course;
import body.measure.Touch;
import game.run.OnOff;
import task.Beep;
import game.Log;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;

/**
 * 競技クラス
 * インスタンスを単一にするため、Singletonパターンを採用
 * @author user119
 *
 */
public class Game {
    // タスクの呼び出し回数
    private int count;
    
    private static Game instance = new Game();
    
    EV3LargeRegulatedMotor leftMotor;
    EV3LargeRegulatedMotor rightMotor;
    EV3TouchSensor touchSensor;
    EV3ColorSensor colorSensor;
    Touch touch;
    Course course;
    Wheel wheel;
    OnOff onOff;
    
    public enum STATUS { CALIBRATION_WHITE, CALIBRATION_BLACK, WAITSTART, RUN, END};
    STATUS status;
    
    private Game() {
        this.leftMotor = new EV3LargeRegulatedMotor(MotorPort.C);
        this.rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
        this.touchSensor = new EV3TouchSensor(SensorPort.S1);
        this.colorSensor = new EV3ColorSensor(SensorPort.S2);
        this.touch = new Touch(touchSensor);
        this.course = new Course(colorSensor);
        this.wheel = new Wheel(leftMotor, rightMotor);
        this.onOff = new OnOff(course, wheel, 200.0f);
        status = STATUS.CALIBRATION_WHITE;
        
        // 暖気運転
        for (int i = 0; i < 1500; i++) {
            course.update();
            wheel.control();
        }
    }
    
    public static Game getInstance() {
        return instance;
    }
    
    /**
     * 実施する
     * @return 実施中はfalse、終了時はtrueを返す
     */
    public boolean run() {
        switch (status) {
        case CALIBRATION_WHITE:
            touch.update();
            course.update();
            if (touch.isUpped()) {
                course.setWhite(course.getBrightness());
                status = STATUS.CALIBRATION_BLACK;
            }
            break;
        case CALIBRATION_BLACK:
            touch.update();
            course.update();
            if (touch.isUpped()) {
                course.setBlack(course.getBrightness());
                course.setTarget((course.getWhite() + course.getBlack()) /2.0f); 
                status = STATUS.WAITSTART;
            }
            break;
        case WAITSTART:
            touch.update();
            course.update();
            if (touch.isUpped()) {
                Beep.ring();
                status = STATUS.RUN;
                Log.setStartTime();
            }
            break;
        case RUN:
            touch.update();
            course.update();
            onOff.run();
            wheel.control();
            if (touch.isUpped()) {
                status = STATUS.END;
            }
            break;
        default:
            break;
        }
        
        if (status == STATUS.END) {
            return true;
        } else {
            return false;
        }
    }
    
    public void countUp() {
        count++;
    }
    
    public STATUS getStatus() {
        return status;
    }
}

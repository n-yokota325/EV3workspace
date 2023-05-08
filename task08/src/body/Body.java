package body;

import body.control.Control;
import body.control.ControlWheel;
import body.measure.Measure;
import body.measure.MeasureCourse;
import body.measure.MeasureTouch;
import body.measure.MeasureWheel;
import hardware.KamogawaRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;

/**
 * ���s�̃N���X
 * @author �㓡�@����
 *
 */
public final class Body {
    /** �v�� */
    public static final Measure measure;
    /** ���� */
    public static final Control control;
    
    /** �ԗւ̔��a(mm) */
    public static final float RADIUS = 40.5f;
    /** �ԗւ̒��a(mm) */
    public static final float DIAMETER = 2.0f * RADIUS;
    /** ���E���ւ̊Ԋu(mm) */
    public static final float TREAD = 128.0f;
  
    static {
        // �n�[�h�E�F�A�̏�����
        EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S2);
        KamogawaRegulatedMotor leftMotor = new KamogawaRegulatedMotor(MotorPort.B);
        KamogawaRegulatedMotor rightMotor = new KamogawaRegulatedMotor(MotorPort.C);

        // �v���̏�����
        MeasureTouch measureTouch = new MeasureTouch(touchSensor);
        MeasureCourse measureCourse = new MeasureCourse(colorSensor);
        MeasureWheel measureWheel = new MeasureWheel(leftMotor, rightMotor);
        measure = new Measure(measureTouch, measureCourse, measureWheel);
        
        // ����̏�����
        ControlWheel controlWheel = new ControlWheel(leftMotor, rightMotor);
        control = new Control(controlWheel);
    }
    
    /**
     * �R���X�g���N�^
     */
    private Body(){

    }
}

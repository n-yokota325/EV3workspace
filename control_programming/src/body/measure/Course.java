package body.measure;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * �H�ʌv���N���X
 * @author user119
 *
 */
public class Course implements Measure{
    private EV3ColorSensor colorSensor;
    private SensorMode sensorMode;
    private float value[];
    
    private float white;
    private float black;
    private float target;
    private float brightness;
    
    public Course(EV3ColorSensor colorSensor) {
        this.colorSensor = colorSensor;
        sensorMode = colorSensor.getRedMode();
        value = new float[sensorMode.sampleSize()];
        
        white = 0.4f;
        black = 0.0f;
        target = (white + black)/2.0f;
    }
    
    /**
     * �X�V����
     */
    @Override
    public void update() {
        sensorMode.fetchSample(value, 0);
        brightness = value[0];
    }
    
    public float getWhite() {
        return white;
    }
    
    public void setWhite(float white) {
        this.white = white;
    }
    
    public float getBlack() {
        return black;
    }
    
    public void setBlack(float black) {
        this.black = black;
    }
    
    public float getTarget() {
        return target;
    }
    
    public void setTarget(float target) {
        this.target = target;
    }
    
    public float getBrightness() {
        return brightness;
    }
}
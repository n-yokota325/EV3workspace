package body.measure;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

/**
 * �H�ʌv���N���X
 * @author �㓡�@����
 *
 */
public class MeasureCourse{
    /** �J���[�Z���T */
    private EV3ColorSensor colorSensor;
    private SensorMode sensorMode;

    /** �����x */
    private float white;
    /** �����x */
    private float black;
    /** �ڕW���x */
    private float target;
    /** �H��RGB�i�ԁA�΁A�j */
    private float rgb[];
    /** �H��HSV�i�F���A�ʓx�A���x�j */
    private float hsv[];
    
    /**
     * �R���X�g���N�^
     * @param colorSensor �J���[�Z���T
     */
    public MeasureCourse(EV3ColorSensor colorSensor){
        this.colorSensor = colorSensor;
        sensorMode =  colorSensor.getRGBMode();
        rgb = new float[sensorMode.sampleSize()];
        hsv = new float[3];
        
        // ���L�����u���[�V����
        white = 0.2f;
        black = 0.0f;
        target = (white + black)/2.0f;
    }
    
    /**
     * �X�V����
     */
    public void update() {
        // RGB���擾����
        sensorMode.fetchSample(rgb, 0);
        
        // RGB��HSV�ɕϊ�����
        RGBtoHSV();
    }
    
    /**
     * RGB��HSV�ɕϊ�����
     */
    private void RGBtoHSV() {
        // rgb�i��:Red�A��:Green�A��:Blue�j
        float r = rgb[0];
        float g = rgb[1];
        float b = rgb[2];
        
        // hsv�i�F��:Hue�A�ʓx:Saturation�A���x:Value�j
        float h, s, v;
        
        // rgb�̍ő�l
        float max = (r > g) ? r : g;
        if (b > max) max = b;
        
        // rgb�̍ŏ��l
        float min = (r < g) ? r : g;
        if (b < min) min = b;

        // rgb����hsv�֕ϊ�
        if (max == min) {
            h = -1.0f;       // ����`
        } else {
            if (max == r) {
                h = (g - b) / (max - min) * 60.0f;
            } else if (max == g) {
                h = (b - r) / (max - min) * 60.0f + 120.0f; 
            } else {
                h = (r - g) / (max - min) * 60.0f + 240.0f;
            }
            if (h < 0.0f) h = h + 360.0f;
            if (h > 360.0f) h = h - 360.0f;
        }
        if (max != 0.0f) {
            s = (max - min) / max; 
        } else {
            s = -1.0f;   // ����`
        }
        v = max;
        
        hsv[0] = h;
        hsv[1] = s;
        hsv[2] = v;
    }
    
    /**
     * �����x���擾����
     * @return�@�����x
     */
    public float getWhite() {
        return white;
    }

    /**
     * �����x��ݒ肷��
     * @param white�@�����x
     */
    public void setWhite(float white) {
        this.white = white;
    }

    /**
     * �����x���擾����
     * @return�@�����x
     */
    public float getBlack() {
        return black;
    }

    /**
     * �����x��ݒ肷��
     * @param black�@�����x
     */
    public void setBlack(float black) {
        this.black = black;
    }

    /**
     * �ڕW���x���擾����
     * @return�@�ڕW���x
     */
    public float getTarget() {
        return target;
    }

    /**
     * �ڕW���x��ݒ肷��
     * @param target�@�ڕW���x
     */
    public void setTarget(float target) {
        this.target = target;
    }
    
    /**
     * �H�ʐF�����擾����
     * @return�@�H�ʐF��
     */
    public float getHue(){
        return hsv[0];
    }
    
    /**
     * �H�ʍʓx���擾����
     * @return�@�H�ʍʓx
     */
    public float getSaturation(){
        return hsv[1];
    }
    
    /**
     * �H�ʖ��x���擾����
     * @return�@�H�ʖ��x
     */
    public float getValue() {
        return hsv[2];
    }
    
}

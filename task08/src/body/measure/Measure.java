package body.measure;

/**
 * �v���N���X
 * �f�U�C���p�^�[����Facade�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class Measure {
    /** �^�b�`�v�� */
    MeasureTouch measureTouch;
    /** �H�ʌv�� */
    MeasureCourse measureCourse;
    /** �ԗ֌v�� */
    MeasureWheel measureWheel;
    
    /**
     * �R���X�g���N�^
     * @param measureTouch �^�b�`�v��
     * @param measureCourse �H�ʌv��
     * @param measureWheel �ԗ֌v��
     */
    public Measure(MeasureTouch measureTouch, MeasureCourse measureCourse, MeasureWheel measureWheel) {
        this.measureTouch = measureTouch;
        this.measureCourse = measureCourse;
        this.measureWheel = measureWheel;
    }
    
    /**
     * �X�V����
     */
    public void update() {
        measureTouch.update();
        measureCourse.update();
        measureWheel.update();
    }
    
    /**
     * �^�b�`�Z���T�������ꂽ��
     * @return �^�b�`�Z���T�������ꂽ�ꍇ��true
     */
    public boolean isUpped() {
        return measureTouch.isUpped();
    }
    
    /**
     * �����x���擾����
     * @return�@�����x
     */
    public float getWhite() {
        return measureCourse.getWhite();
    }

    /**
     * �����x��ݒ肷��
     * @param white�@�����x
     */
    public void setWhite(float white) {
        measureCourse.setWhite(white);
    }

    /**
     * �����x���擾����
     * @return�@�����x
     */
    public float getBlack() {
        return measureCourse.getBlack();
    }

    /**
     * �����x��ݒ肷��
     * @param black�@�����x
     */
    public void setBlack(float black) {
        measureCourse.setBlack(black);
    }
    
    /**
     * �ڕW���x���擾����
     * @return�@�ڕW���x
     */
    public float getTarget() {
        return measureCourse.getTarget();
    }
    
    /**
     * �ڕW���x��ݒ肷��
     * @param target�@�ڕW���x
     */
    public void setTarget(float target) {
        measureCourse.setTarget(target);
    }
    
    /**
     * �H�ʐF�����擾����
     * @return�@�F��
     */
    public float getHue(){
        return measureCourse.getHue();
    }
    
    /**
     * �H�ʍʓx���擾����
     * @return�@�ʓx
     */
    public float getSaturation(){
        return measureCourse.getSaturation();
    }
    
    /**
     * �H�ʖ��x���擾����
     * @return�@�H�ʖ��x
     */
    public float getValue() {
        return measureCourse.getValue();
    }
    
    /**
     * �����[�^�̊p���x(�x/�b)���v������
     * @return leftRotationSpeed�@�����[�^�̊p���x(�x/�b)
     */
    public float getLeftRotationSpeed() {
        return measureWheel.getLeftRotationSpeed();
    }

    /**
     * �E���[�^�̊p���x(�x/�b)���v������
     * @return rightRotationSpeed�@�E���[�^�̊p���x(�x/�b)
     */
    public float getRightRotationSpeed() {
        return measureWheel.getRightRotationSpeed();
    }

}

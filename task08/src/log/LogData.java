package log;

/**
 * ���O�f�[�^�N���X
 * @author �㓡�@����
 *
 */
public class LogData {
    /** �^�X�N�ďo�� */
    private int count;
    /** ���Z��Ԗ� */
    private String statusName;
    /** �H�ʐF���@*/
    private float hue;
    /** �H�ʍʓx�@*/
    private float saturation;
    /** �H�ʖ��x�@*/
    private float value;
    /** �����[�^�̊p���x(�x/�b) */
    private float leftRotationSpeed;
    /** �E���[�^�̊p���x(�x/�b) */
    private float rightRotationSpeed;
    
    /**
     * �R���X�g���N�^
     * @param count �^�X�N�̌Ăяo����
     * @param status ���Z��Ԗ�
     * @param hue �H�ʐF��
     * @param saturation �H�ʍʓx
     * @param brightness �H�ʖ��x
     * @param leftRotationSpeed �����[�^�̊p���x(�x/�b)
     * @param rightRotationSpeed �E���[�^�̊p���x(�x/�b)
     */
    public LogData(int count, String statusName, float hue, float saturation, float value, float leftRotationSpeed, float rightRotationSpeed){
        this.count = count;
        this.statusName = statusName;
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
        this.leftRotationSpeed = leftRotationSpeed;
        this.rightRotationSpeed = rightRotationSpeed;
    }


    /**
     * �I�u�W�F�N�g�̕�����\�����擾����
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append(",");
        sb.append(statusName);
        sb.append(",");
        sb.append(hue);
        sb.append(",");
        sb.append(saturation);
        sb.append(",");
        sb.append(value);
        sb.append(",");
        sb.append(leftRotationSpeed);
        sb.append(",");
        sb.append(rightRotationSpeed);
        sb.append("\r\n");
        
        return sb.toString();
    }
}

package ev3Sensor;

public interface EV3SensorMode {
    // �^�b�`�Z���T�[
    public static final int TOUCHMODE = 0;  // �^�b�`���[�h
    // �J���[�Z���T�[
    public static final int COLORMODE = 0;  // �F���[�h
    public static final int REFLECTMODE = 1;// ���ˌ����[�h
    public static final int AMBIENTMODE = 3;// ���ӌ����[�h
    // �W���C���Z���T�[
    public static final int ANGLEMODE = 1;  // �p�x���[�h
    public static final int RATEMODE = 0;   // �p���x���[�h
    // �����g�Z���T�[
    public static final int DISTANCEMODE = 0;   // �������[�h�i���[�g���j
    public static final int LISTENMODE = 1;     // ���݃��[�h
}

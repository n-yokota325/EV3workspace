package game;

/**
 * �����x�L�����u���[�V������ԃN���X
 * �f�U�C���p�^�[����Singleton�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class StateCalibrationBlack extends State {
    /** �C���X�^���X */
    private static StateCalibrationBlack instance = new StateCalibrationBlack();

    /** �R���X�g���N�^ */
    private StateCalibrationBlack() {
        name = "CalibrationBlack";
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    @Override
    public void changeState(Game game) {
        game.changeState(this, StateWaitStart.getInstance());
    }

    /**
     * �C���X�^���X���擾����
     * @return �C���X�^���X
     */
    public static StateCalibrationBlack getInstance() {
        return instance;
    }

}

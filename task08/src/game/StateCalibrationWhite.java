package game;

/**
 * �����x�L�����u���[�V������ԃN���X
 * �f�U�C���p�^�[����Singleton�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class StateCalibrationWhite extends State {
    /** �C���X�^���X */
    private static StateCalibrationWhite instance = new StateCalibrationWhite();

    /**
     * �R���X�g���N�^
     */
    private StateCalibrationWhite() {
        name = "CalibrationWhite";
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    @Override
    public void changeState(Game game) {
        game.changeState(this, StateCalibrationBlack.getInstance());
    }

    /**
     * �C���X�^���X���擾����
     * @return �C���X�^���X
     */
    public static StateCalibrationWhite getInstance() {
        return instance;
    }

}

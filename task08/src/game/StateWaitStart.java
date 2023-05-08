package game;

/**
 * �X�^�[�g�҂���ԃN���X
 * �f�U�C���p�^�[����Singleton�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class StateWaitStart extends State {
    /** �C���X�^���X */
    private static StateWaitStart instance = new StateWaitStart();

    /**
     * �R���X�g���N�^
     */
    private StateWaitStart() {
        name = "WaitStart";
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    @Override
    public void changeState(Game game) {
        game.changeState(this, StateRun.getInstance());
    }

    /**
     * �C���X�^���X���擾����
     * @return �C���X�^���X
     */
    public static StateWaitStart getInstance() {
        return instance;
    }

}

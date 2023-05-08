package game;

/**
 * ���s��ԃN���X
 * �f�U�C���p�^�[����Singleton�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class StateRun extends State {
    /** �C���X�^���X */
    private static StateRun instance = new StateRun();
    
    /**
     * �R���X�g���N�^
     */
    private StateRun() {
        name = "Run";
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    @Override
    public void changeState(Game game) {
        game.changeState(this, StateEnd.getInstance());
    }

    /**
     * �C���X�^���X���擾����
     * @return �C���X�^���X
     */
    public static StateRun getInstance() {
        return instance;
    }

}

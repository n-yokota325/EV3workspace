package game;

/**
 * ���Z�I����ԃN���X
 * �f�U�C���p�^�[����Singleton�p�^�[�����̗p
 * @author �㓡�@����
 *
 */
public class StateEnd extends State {
    /** �C���X�^���X */
    private static StateEnd instance = new StateEnd();
    
    /**
     * �R���X�g���N�^
     */
    private StateEnd() {
        name = "End";
    }

    /**
     * ���Z��Ԃ�J�ڂ���
     * @param game ���Z
     */
    @Override
    public void changeState(Game game) {
        
    }

    /**
     * �C���X�^���X���擾����
     * @return �C���X�^���X
     */
    public static StateEnd getInstance() {
        return instance;
    }

}

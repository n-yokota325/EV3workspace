package task;

import lejos.hardware.Sound;

/**
 * Beep�N���X
 * @author �㓡 ����
 *
 */
public class Beep {

    /**
     * Beep����炷
     */
    public static void ring() {
        Thread beepTask = new Thread(new Runnable() {
            @Override
            public void run() {
                Sound.beep();
            }
        });
        beepTask.setPriority(Thread.MIN_PRIORITY);
        beepTask.start();
    }

}

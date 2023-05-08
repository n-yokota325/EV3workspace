package task;

import lejos.hardware.Sound;

/**
 * BeepƒNƒ‰ƒX
 * @author Œã“¡ ‘•¶
 *
 */
public class Beep {

    /**
     * Beep‰¹‚ğ–Â‚ç‚·
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

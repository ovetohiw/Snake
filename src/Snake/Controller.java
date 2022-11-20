package Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    GameOptions gO;

    public Controller(GameOptions gO){
        this.gO = gO;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: {
                if (gO.getStep_x() != 0) {
                    gO.setStep_x(0);
                    gO.setStep_y(-1);
                }
                break;
            }
            case KeyEvent.VK_S: {
                if (gO.getStep_x() != 0) {
                    gO.setStep_x(0);
                    gO.setStep_y(1);
                }
                break;
            }
            case KeyEvent.VK_D: {
                if (gO.getStep_y() != 0) {
                    gO.setStep_x(1);
                    gO.setStep_y(0);
                }
                break;
            }
            case KeyEvent.VK_A: {
                if (gO.getStep_y() != 0) {
                    gO.setStep_x(-1);
                    gO.setStep_y(0);
                }
                break;
            }
        }
    }
}

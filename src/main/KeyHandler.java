package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Associated KeyCode numbers (for keys)
 * 8 -- Backspace  9 -- Tab
 * 10 -- Enter     12 -- Clear
 * 16 -- Shift     17 -- Ctrl
 * 18 -- Alt
 * 65 -- A         66 -- B
 * 67 -- C         68 -- D
 * 69 -- E         70 -- F
 * 71 -- G         72 -- H
 * 73 -- I         74 -- J
 */

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            // if 'W' key is pressed
            upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            // if 'S' key is pressed
            downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            // if 'A' key is pressed
            leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
            // if 'D' key is pressed
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            // if 'W' key is released
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            // if 'S' key is released
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            // if 'A' key is released
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            // if 'D' key is released
            rightPressed = false;
        }
    }
}

package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // Screen settings
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;

        // Screen size
    final int tileSize = originalTileSize * scale; // 48 x 48, scaled for better resolutions
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Setting the player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // offscreen painting buffer, improves game's rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThreat() {
        gameThread = new Thread(this);
        gameThread.start();
    }

//    @Override
//    public void run() {
//        // FPS sleep method
//        double drawInterval = 1000000000 / FPS; // Dividing from nanoseconds for greater accuracy. 0.01667 secs.
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while(gameThread != null) {
//
//            // 1. UPDATE information such as character positions.
//            update();
//
//            // 2. DRAW on the screen with the updated information.
//            repaint(); // <-- this calls painComponent()
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime(); // Time left after update() and repaint() are called.
//                remainingTime = remainingTime / 1000000; // Combating Thread.sleep milli-second convertion.
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//                nextDrawTime += drawInterval;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {
        // Delta/Accumulator method
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose(); // Rids off graphics context and release any system resources that it's using.
    }
}

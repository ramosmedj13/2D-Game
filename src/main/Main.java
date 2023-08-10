package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack(); // causes 'window' to be sized to fit the preferred size and layout of its subcomponents (GP).

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThreat();
    }
}

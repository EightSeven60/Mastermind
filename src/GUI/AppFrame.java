package GUI;

import Interfaces.CustomAction;
import utilitymethods.CodeGenerator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class AppFrame extends JFrame {
    protected int screenWidth;
    protected int screenHeight;

    protected GraphicsDevice graphicsDevice;

    protected JLabel gamePanelBackground;

    protected JButton exitButton;
    //protected JButtonWithConfirmation exitButton2;
    protected JButton saveButton;
    protected JButton loadButton;

    protected Timer exitTimer;

    protected class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                if (exitButton.getText().contentEquals("Are you sure?")) {
                    System.exit(0);
                } else {
                    exitButton.setText("Are you sure?");
                    exitTimer.start();
                }
            }
            else {
                exitButton.setText("EXIT");
                exitTimer.stop();
            }

        }
    }
    protected class EXLIS implements CustomAction {
        @Override
        public void action() {
            System.exit(0);
        }
    }
    protected class SaveListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //ask for confirmation
            //save game state to file
        }
    }
    protected class LoadListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //ask for confirmation
            //load game state from file
        }
    }

    protected JPanel mainPanel;
    protected JPanel menuPanel;

    protected JLabelBall[][] guessBalls;
    protected JPanel guessMatrixPanel;

    protected JLabelHint[][][] hints;
    protected JPanel[] hintArea;
    protected JPanel hintPanel;

    protected JLabelBall[] targetBalls;
    protected JPanel targetGuessPanel;
    protected JPanel gamePanel;

    public AppFrame() {

        graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = graphicsDevice.getDisplayMode().getWidth();
        screenHeight = graphicsDevice.getDisplayMode().getHeight();

        ExitListener exitListener = new ExitListener();
        SaveListener saveListener = new SaveListener();
        LoadListener loadListener = new LoadListener();

        exitTimer = new Timer(2000, exitListener);

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        exitButton = new JButton("EXIT");
        exitButton.setFocusable(false);
        exitButton.addActionListener(exitListener);

        //exitButton2 = new JButtonWithConfirmation("exit2", new EXLIS());

        saveButton = new JButton("SAVE");
        saveButton.setFocusable(false);
        saveButton.addActionListener(saveListener);

        loadButton = new JButton("LOAD");
        loadButton.setFocusable(false);
        loadButton.addActionListener(loadListener);

        menuPanel = new JPanel(new GridLayout());
        menuPanel.setOpaque(true);
        menuPanel.setBackground(new Color(50, 50, 10));
        menuPanel.setPreferredSize(new Dimension(0, 40));
        menuPanel.add(exitButton);
        menuPanel.add(saveButton);
        menuPanel.add(loadButton);
        //menuPanel.add(exitButton2);

        ImageIcon background = new ImageIcon("Resources//GUI background marked.png");
        background.setImage(background.getImage().getScaledInstance(1920, 1040,0));

        gamePanelBackground = new JLabel(background);
        gamePanelBackground.setLocation(0, 0);
        gamePanelBackground.setSize(1920, 1040);

        hintArea = new JPanel[10];
        hints = new JLabelHint[10][2][2];
        for (int i = 0; i < 10; ++i) {
            hintArea[i] = new JPanel(new GridLayout(2, 2));
            hints[i] = new JLabelHint[2][2];
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++k) {
                    hints[i][j][k] = new JLabelHint();
                    hintArea[i].add(hints[i][j][k]);
                }
            }
            hintArea[i].setOpaque(false);
        }

        hintPanel = new JPanel(new GridLayout(1, 10));
        hintPanel.setLocation(375, 211);
        hintPanel.setSize(1510, 156);
        hintPanel.setBackground(new Color(70, 0, 0));
        hintPanel.setOpaque(false);
        for (int i = 0; i < 10; ++i) {
            hintPanel.add(hintArea[i]);
        }

        CodeGenerator codeGenerator = new CodeGenerator();
        codeGenerator.setNumbers();
        targetBalls = new JLabelBall[4];
        targetBalls[0] = new JLabelBall(codeGenerator.get_wCode1(), false);
        targetBalls[1] = new JLabelBall(codeGenerator.get_wCode2(), false);
        targetBalls[2] = new JLabelBall(codeGenerator.get_wCode3(), false);
        targetBalls[3] = new JLabelBall(codeGenerator.get_wCode4(), false);

        targetGuessPanel = new JPanel(new GridLayout(4, 1));
        targetGuessPanel.setLocation(59, 366);
        targetGuessPanel.setSize(151, 617);
        targetGuessPanel.setBackground(new Color(70, 0, 0));
        targetGuessPanel.setOpaque(false);
        for (int i = 0; i < 4; ++i) {
            targetGuessPanel.add(targetBalls[i]);
        }

        guessMatrixPanel = new JPanel(new GridLayout(4, 10));
        guessMatrixPanel.setLocation(361, 366);
        guessMatrixPanel.setSize(1510, 617);
        guessMatrixPanel.setBackground(new Color(100, 0, 0));
        guessMatrixPanel.setOpaque(false);

        guessBalls = new JLabelBall[10][4];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 4; ++j) {
                guessBalls[i][j] = new JLabelBall(true);
                guessMatrixPanel.add(guessBalls[i][j]);
            }
        }

        gamePanel = new JPanel(null);
        gamePanel.setOpaque(true);
        gamePanel.setBackground(new Color(25, 25, 25));
        gamePanel.add(hintPanel);
        gamePanel.add(targetGuessPanel);
        gamePanel.add(guessMatrixPanel);
        gamePanel.add(gamePanelBackground);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0, 0, 50));
        mainPanel.setOpaque(true);
        mainPanel.add(menuPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);

        this.setContentPane(mainPanel);
        this.setVisible(true);
        //graphicsDevice.setFullScreenWindow(this);

        System.out.println("mainPanelWidth: " + mainPanel.getWidth() +
                "\nmainPanelHeight: " + mainPanel.getHeight());
        System.out.println("Screen width: " + screenWidth +
                "\nScreen height: " + screenHeight);
        System.out.println("thisX: " + this.getX() +
                "\nthisY: " + this.getY() +
                "\nthisWidth: " + this.getWidth() +
                "\nthisHeight: " + this.getHeight());
        System.out.println("gamePanel height: " + gamePanel.getHeight() +
                "\n gamePanel width: " + gamePanel.getWidth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppFrame appFrame = (AppFrame) o;
        return screenWidth == appFrame.screenWidth &&
                screenHeight == appFrame.screenHeight &&
                graphicsDevice.equals(appFrame.graphicsDevice) &&
                gamePanelBackground.equals(appFrame.gamePanelBackground) &&
                exitButton.equals(appFrame.exitButton) &&
                saveButton.equals(appFrame.saveButton) &&
                loadButton.equals(appFrame.loadButton) &&
                exitTimer.equals(appFrame.exitTimer) &&
                mainPanel.equals(appFrame.mainPanel) &&
                menuPanel.equals(appFrame.menuPanel) &&
                guessMatrixPanel.equals(appFrame.guessMatrixPanel) &&
                hintPanel.equals(appFrame.hintPanel) &&
                targetGuessPanel.equals(appFrame.targetGuessPanel) &&
                gamePanel.equals(appFrame.gamePanel);
    }
}

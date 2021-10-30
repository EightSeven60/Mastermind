package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame {
    protected int screenWidth;
    protected int screenHeight;

    protected GraphicsDevice graphicsDevice;

    protected JLabel gamePanelBackground;

    protected JButton exitButton;
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

    protected JPanel guessMatrixPanel;
    protected JPanel hintPanel;
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

        ImageIcon background = new ImageIcon("Resources//GUI background marked.png");
        background.setImage(background.getImage().getScaledInstance(1920, 1040,0));

        gamePanelBackground = new JLabel(background);
        gamePanelBackground.setLocation(0, 0);
        gamePanelBackground.setSize(1920, 1040);

        hintPanel = new JPanel(new GridLayout(1, 10));
        hintPanel.setLocation(356, 211);
        hintPanel.setSize(1510, 156);
        //hintPanel.setBackground(new Color(70, 0, 0));
        hintPanel.setOpaque(false);

        targetGuessPanel = new JPanel(new GridLayout(4, 1));
        targetGuessPanel.setLocation(54, 366);
        targetGuessPanel.setSize(151, 617);
        //targetGuessPanel.setBackground(new Color(70, 0, 0));
        targetGuessPanel.setOpaque(false);

        guessMatrixPanel = new JPanel(new GridLayout(10, 4));
        guessMatrixPanel.setLocation(356, 366);
        guessMatrixPanel.setSize(1510, 617);
        //guessMatrixPanel.setBackground(new Color(70, 0, 0));
        guessMatrixPanel.setOpaque(false);

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
        graphicsDevice.setFullScreenWindow(this);

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
}

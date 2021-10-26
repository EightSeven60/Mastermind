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

    protected JButton exitButton;
    protected JButton saveButton;
    protected JButton loadButton;

    protected Timer timer;

    protected class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exitButton) {
                if (exitButton.getText().contentEquals("Are you sure?")) {
                    System.exit(0);
                } else {
                    exitButton.setText("Are you sure?");
                    timer.start();
                }
            }
            else {
                exitButton.setText("EXIT");
                timer.stop();
            }

        }
    }
    protected class SaveListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //save game state to file
        }
    }
    protected class LoadListener implements  ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //load game state from file
        }
    }

    protected JPanel mainPanel;
    protected JPanel menuPanel;
    protected JPanel gamePanel;
    protected JPanel ballSelectorPanel;
    protected JPanel nullSouthPanel;

    public AppFrame() {

        graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = graphicsDevice.getDisplayMode().getWidth();
        screenHeight = graphicsDevice.getDisplayMode().getHeight();

        ExitListener exitListener = new ExitListener();
        SaveListener saveListener = new SaveListener();
        LoadListener loadListener = new LoadListener();

        timer = new Timer(2000, exitListener);

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

        ballSelectorPanel = new JPanel();
        ballSelectorPanel.setOpaque(true);
        ballSelectorPanel.setBackground(new Color(0, 0, 100));
        ballSelectorPanel.setPreferredSize(new Dimension(300, 0));

        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setOpaque(true);
        gamePanel.setBackground(new Color(0, 100, 0));
        gamePanel.add(ballSelectorPanel, BorderLayout.EAST);

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
    }
}

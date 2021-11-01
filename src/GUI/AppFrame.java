package GUI;

import Classes.AllocationException;
import Classes.GameBoard;
import utilitymethods.CodeGenerator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Objects;

public class AppFrame extends JFrame {
    GameBoard gameBoard;

    protected int screenWidth;
    protected int screenHeight;

    protected int currentRow; //a row is VERTICAL in the GUI

    protected GraphicsDevice graphicsDevice;

    protected JLabel gamePanelBackground;

    protected JButtonWithConfirmation exitButton;
    protected JButtonWithConfirmation saveButton;
    protected JButtonWithConfirmation loadButton;
    protected JButtonWithConfirmation guessButton;

    protected JPanel mainPanel;
    protected JPanel menuPanel;

    protected JLabelBall[][] guessBalls;
    protected JPanel guessMatrixPanel;

    protected JLabelHint[][][] hints;
    protected JPanel[] hintArea;
    protected JPanel hintPanel;

    protected JLabelBall[] targetBalls;
    protected JLabel targetCover;
    protected JPanel targetGuessPanel;
    protected JPanel gamePanel;

    public AppFrame(GameBoard gameBoard) {
        super();
        this.gameBoard = gameBoard;

        graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = graphicsDevice.getDisplayMode().getWidth();
        screenHeight = graphicsDevice.getDisplayMode().getHeight();
        currentRow = 0;

        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            exitButton = new JButtonWithConfirmation("EXIT", new ExitAction());
            saveButton = new JButtonWithConfirmation("SAVE", new SaveAction());
            loadButton = new JButtonWithConfirmation("LOAD", new LoadAction());
            guessButton = new JButtonWithConfirmation("SUBMIT GUESS", new SubmitGuessAction());
        }
        catch (AllocationException e) {
            e.printStackTrace();
        }

        menuPanel = new JPanel(new GridLayout());
        menuPanel.setOpaque(true);
        menuPanel.setBackground(new Color(50, 50, 10));
        menuPanel.setPreferredSize(new Dimension(0, 40));
        menuPanel.add(guessButton);
        menuPanel.add(loadButton);
        menuPanel.add(saveButton);
        menuPanel.add(exitButton);

        ImageIcon background = new ImageIcon("Resources//GUI background.png");
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

        targetCover = new JLabel(new ImageIcon("Resources//target cover.png"));
        targetCover.setLocation(targetGuessPanel.getX(), targetGuessPanel.getY());
        targetCover.setSize(targetGuessPanel.getWidth(), targetGuessPanel.getHeight());

        guessMatrixPanel = new JPanel(new GridLayout(4, 10));
        guessMatrixPanel.setLocation(361, 366);
        guessMatrixPanel.setSize(1510, 617);
        guessMatrixPanel.setBackground(new Color(100, 0, 0));
        guessMatrixPanel.setOpaque(false);

        guessBalls = new JLabelBall[4][10];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 10; ++j) {
                guessBalls[i][j] = new JLabelBall(i % 6, true);
                guessBalls[i][j].setVisible(false);
                guessMatrixPanel.add(guessBalls[i][j]);
            }
        }
        for (int i = 0; i < 4; ++i) {
            guessBalls[i][currentRow].setVisible(true);
        }

        gamePanel = new JPanel(null);
        gamePanel.setOpaque(true);
        gamePanel.setBackground(new Color(25, 25, 25));
        gamePanel.add(hintPanel);
        gamePanel.add(targetCover);
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

    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getCurrentRow() {
        return currentRow;
    }
    public GraphicsDevice getGraphicsDevice() {
        return graphicsDevice;
    }
    public JLabel getGamePanelBackground() {
        return gamePanelBackground;
    }
    public JButtonWithConfirmation getExitButton() {
        return exitButton;
    }
    public JButtonWithConfirmation getSaveButton() {
        return saveButton;
    }
    public JButtonWithConfirmation getLoadButton() {
        return loadButton;
    }
    public JButtonWithConfirmation getGuessButton() {
        return guessButton;
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public JPanel getMenuPanel() {
        return menuPanel;
    }
    public JLabelBall[][] getGuessBalls() {
        return guessBalls;
    }
    public JPanel getGuessMatrixPanel() {
        return guessMatrixPanel;
    }
    public JLabelHint[][][] getHints() {
        return hints;
    }
    public JPanel[] getHintArea() {
        return hintArea;
    }
    public JPanel getHintPanel() {
        return hintPanel;
    }
    public JLabelBall[] getTargetBalls() {
        return targetBalls;
    }
    public JLabel getTargetCover() {
        return targetCover;
    }
    public JPanel getTargetGuessPanel() {
        return targetGuessPanel;
    }
    public JPanel getGamePanel() {
        return gamePanel;
    }
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }
    public void setGraphicsDevice(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }
    public void setGamePanelBackground(JLabel gamePanelBackground) {
        this.gamePanelBackground = gamePanelBackground;
    }
    public void setExitButton(JButtonWithConfirmation exitButton) {
        this.exitButton = exitButton;
    }
    public void setSaveButton(JButtonWithConfirmation saveButton) {
        this.saveButton = saveButton;
    }
    public void setLoadButton(JButtonWithConfirmation loadButton) {
        this.loadButton = loadButton;
    }
    public void setGuessButton(JButtonWithConfirmation guessButton) {
        this.guessButton = guessButton;
    }
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }
    public void setGuessBalls(JLabelBall[][] guessBalls) {
        this.guessBalls = guessBalls;
    }
    public void setGuessMatrixPanel(JPanel guessMatrixPanel) {
        this.guessMatrixPanel = guessMatrixPanel;
    }
    public void setHints(JLabelHint[][][] hints) {
        this.hints = hints;
    }
    public void setHintArea(JPanel[] hintArea) {
        this.hintArea = hintArea;
    }
    public void setHintPanel(JPanel hintPanel) {
        this.hintPanel = hintPanel;
    }
    public void setTargetBalls(JLabelBall[] targetBalls) {
        this.targetBalls = targetBalls;
    }
    public void setTargetCover(JLabel targetCover) {
        this.targetCover = targetCover;
    }
    public void setTargetGuessPanel(JPanel targetGuessPanel) {
        this.targetGuessPanel = targetGuessPanel;
    }
    public void setGamePanel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public String toString() {
        return "AppFrame{" +
                "screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", currentRow=" + currentRow +
                ", graphicsDevice=" + graphicsDevice +
                ", gamePanelBackground=" + gamePanelBackground +
                ", exitButton=" + exitButton +
                ", saveButton=" + saveButton +
                ", loadButton=" + loadButton +
                ", guessButton=" + guessButton +
                ", mainPanel=" + mainPanel +
                ", menuPanel=" + menuPanel +
                ", guessBalls=" + Arrays.toString(guessBalls) +
                ", guessMatrixPanel=" + guessMatrixPanel +
                ", hints=" + Arrays.toString(hints) +
                ", hintArea=" + Arrays.toString(hintArea) +
                ", hintPanel=" + hintPanel +
                ", targetBalls=" + Arrays.toString(targetBalls) +
                ", targetCover=" + targetCover +
                ", targetGuessPanel=" + targetGuessPanel +
                ", gamePanel=" + gamePanel +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppFrame)) return false;
        AppFrame appFrame = (AppFrame) o;
        return screenWidth == appFrame.screenWidth && screenHeight == appFrame.screenHeight && currentRow == appFrame.currentRow && Objects.equals(graphicsDevice, appFrame.graphicsDevice) && Objects.equals(gamePanelBackground, appFrame.gamePanelBackground) && Objects.equals(exitButton, appFrame.exitButton) && Objects.equals(saveButton, appFrame.saveButton) && Objects.equals(loadButton, appFrame.loadButton) && Objects.equals(guessButton, appFrame.guessButton) && Objects.equals(mainPanel, appFrame.mainPanel) && Objects.equals(menuPanel, appFrame.menuPanel) && Arrays.equals(guessBalls, appFrame.guessBalls) && Objects.equals(guessMatrixPanel, appFrame.guessMatrixPanel) && Arrays.equals(hints, appFrame.hints) && Arrays.equals(hintArea, appFrame.hintArea) && Objects.equals(hintPanel, appFrame.hintPanel) && Arrays.equals(targetBalls, appFrame.targetBalls) && Objects.equals(targetCover, appFrame.targetCover) && Objects.equals(targetGuessPanel, appFrame.targetGuessPanel) && Objects.equals(gamePanel, appFrame.gamePanel);
    }
}

package GUI;

import Classes.InvalidColorException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class JLabelBall extends JLabel {
    public static final int COLOR_RED = 0;
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_YELLOW = 3;
    public static final int COLOR_TURQUOISE = 4;
    public static final int COLOR_PURPLE = 5;

    public int color;

    public class ClickListener implements MouseListener {
        public void throwException() throws InvalidColorException {
            throw new InvalidColorException("Tried to set invalid color to ball.");
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {
            if (color < 5) {
                ++color;
                switch (color) {
                    case 1:
                        setIcon(new ImageIcon("Resources//Blue ball.png"));
                        break;
                    case 2:
                        setIcon(new ImageIcon("Resources//Green ball.png"));
                        break;
                    case 3:
                        setIcon(new ImageIcon("Resources//Yellow ball.png"));
                        break;
                    case 4:
                        setIcon(new ImageIcon("Resources//Turquoise ball.png"));
                        break;
                    case 5:
                        setIcon(new ImageIcon("Resources//Purple ball.png"));
                        break;
                    default:
                        try {
                            throwException();
                        }
                        catch (InvalidColorException exception) {
                            exception.printStackTrace();
                        }
                        break;
                }
            }
            else {
                color = 0;
                setIcon(new ImageIcon("Resources//Red ball.png"));
            }

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public JLabelBall(int colorClassConstant, boolean changeColorOnClick) {
        super();
        color = colorClassConstant;
        switch (colorClassConstant) {
            case 0 -> this.setIcon(new ImageIcon("Resources//Red ball.png"));
            case 1 -> this.setIcon(new ImageIcon("Resources//Blue ball.png"));
            case 2 -> this.setIcon(new ImageIcon("Resources//Green ball.png"));
            case 3 -> this.setIcon(new ImageIcon("Resources//Yellow ball.png"));
            case 4 -> this.setIcon(new ImageIcon("Resources//Turquoise ball.png"));
            case 5 -> this.setIcon(new ImageIcon("Resources//Purple ball.png"));
            default -> System.out.println("Color passed in ball constructor was invalid.");
        }
        if (changeColorOnClick) {
            this.addMouseListener(new ClickListener());
        }
    }
    public JLabelBall(boolean changeColorOnClick) {
        super();
        Random random = new Random();
        switch (color = random.nextInt(6)) {
            case 0 -> this.setIcon(new ImageIcon("Resources//Red ball.png"));
            case 1 -> this.setIcon(new ImageIcon("Resources//Blue ball.png"));
            case 2 -> this.setIcon(new ImageIcon("Resources//Green ball.png"));
            case 3 -> this.setIcon(new ImageIcon("Resources//Yellow ball.png"));
            case 4 -> this.setIcon(new ImageIcon("Resources//Turquoise ball.png"));
            case 5 -> this.setIcon(new ImageIcon("Resources//Purple ball.png"));
            default -> System.out.println("Color passed in ball constructor was invalid.");
        }
        if (changeColorOnClick) {
            this.addMouseListener(new ClickListener());
        }
    }
}

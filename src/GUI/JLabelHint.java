package GUI;

import Classes.InvalidColorException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Random;

public class JLabelHint extends JLabel {
    public static final int COLOR_BLACK = 6;
    public static final int COLOR_WHITE = 7;
    public static final int COLOR_NULL = 8;

    public int color;

    public void throwException() throws InvalidColorException {
        throw new InvalidColorException("Tried to set invalid color to ball.");
    }

    public void setColor() {
        switch (color) {
            case 6:
                setIcon(new ImageIcon("Resources//Black hint.png"));
                break;
            case 7:
                setIcon(new ImageIcon("Resources//White hint.png"));
                break;
            case 8:
                setIcon(new ImageIcon("Resources//Null hint.png"));
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

    public JLabelHint(int colorClassConstant) {
        super();
        color = colorClassConstant;
        switch (colorClassConstant) {
            case 6 -> this.setIcon(new ImageIcon("Resources//Black hint.png"));
            case 7 -> this.setIcon(new ImageIcon("Resources//White hint.png"));
            case 8 -> this.setIcon(new ImageIcon("Resources//Null hint.png"));
            default -> System.out.println("Color passed in ball constructor was invalid.");
        }
        this.setVisible(false);
    }
    public JLabelHint() {
        this.color = COLOR_NULL;
        this.setIcon(new ImageIcon("Resources//Null hint.png"));
        this.setVisible(false);
    }
    @Override
    public String toString() {
        return "Color: " + color + "\n";
    }
}

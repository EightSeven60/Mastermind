package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JLabelCustom extends JLabel {
    public static final int COLOR_RED = 0;
    public static final int COLOR_BLUE = 1;
    public static final int COLOR_GREEN = 2;
    public static final int COLOR_YELLOW = 3;
    public static final int COLOR_TURQUOISE = 4;
    public static final int COLOR_PURPLE = 5;

    public int color;

    public class ClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (color < 5) {
                ++color;
            }
            else {
                color = 0;
            }
        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public JLabelCustom(Icon image) {
        super(image);
        color = 0;
        this.addMouseListener(new ClickListener());
    }
}

package GUI;

import Interfaces.CustomAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonWithConfirmation extends JButton {

    protected String defaultText;
    protected Timer timer;
    protected CustomAction customAction;

    public JButtonWithConfirmation(String defaultText, CustomAction customAction) {
        super();
        timer = new Timer(2000, new ListenerWithConfirmation(this, timer));
        this.defaultText = defaultText;
        this.customAction = customAction;
        this.setText(defaultText);
        this.setFocusable(false);
        this.addActionListener(new ListenerWithConfirmation(this, timer));
    }

    protected static class ListenerWithConfirmation implements ActionListener {
        protected JButtonWithConfirmation button;

        ListenerWithConfirmation(JButtonWithConfirmation button, Timer timer) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                if (button.getText().contentEquals("Are you sure?")) {
                    button.customAction.action();
                    button.setText(button.defaultText);
                    button.timer.stop();
                } else {
                    button.setText("Are you sure?");
                    button.timer.start();
                }
            }
            else {
                button.setText(button.defaultText);
                button.timer.stop();
            }

        }
    }

}

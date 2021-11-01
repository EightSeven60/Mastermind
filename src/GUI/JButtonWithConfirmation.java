package GUI;

import Classes.AllocationException;
import Interfaces.ICustomAction;

import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class JButtonWithConfirmation extends JButton {

    protected String defaultText;
    protected Timer timer;
    protected ICustomAction ICustomAction;

    public JButtonWithConfirmation(String defaultText, ICustomAction ICustomAction) throws AllocationException {
        super();
        timer = new Timer(2000, new ListenerWithConfirmation(this, timer));
        if (timer == null) throw new AllocationException("Could not allocate space for custom button timer.");
        this.defaultText = defaultText;
        this.ICustomAction = ICustomAction;
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
                    button.ICustomAction.action();
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

    public String getDefaultText() {
        return defaultText;
    }
    public Timer getTimer() {
        return timer;
    }
    public Interfaces.ICustomAction getICustomAction() {
        return ICustomAction;
    }
    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }
    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    public void setICustomAction(Interfaces.ICustomAction ICustomAction) {
        this.ICustomAction = ICustomAction;
    }
    @Override
    public String toString() {
        return "JButtonWithConfirmation{" +
                "defaultText='" + defaultText + '\'' +
                ", timer=" + timer +
                ", ICustomAction=" + ICustomAction +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JButtonWithConfirmation that = (JButtonWithConfirmation) o;
        return Objects.equals(defaultText, that.defaultText) && Objects.equals(timer, that.timer) && Objects.equals(ICustomAction, that.ICustomAction);
    }
}

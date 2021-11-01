package GUI;

import Interfaces.ICustomAction;

public class ExitAction implements ICustomAction {
    @Override
    public void action() {
        System.exit(0);
    }
}
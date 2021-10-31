package GUI;


import Interfaces.CustomAction;

public class ExitAction implements CustomAction {
    @Override
    public void action() {
        System.exit(0);
    }
}
package application;

import terminal.TerminalType;

public class Global {
    public String hackStr;
    private static final Global singleton = new Global();
    private Global() {}
    public static Global getInstance() {
        return singleton;
    }

    public TerminalType status = TerminalType.Default;

    public void setType(TerminalType status) {
        this.status=status;
    }

}
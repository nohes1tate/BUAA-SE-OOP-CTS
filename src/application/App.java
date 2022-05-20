package application;

import terminal.Default;
import terminal.Sudo;
import terminal.TerminalType;

import java.io.IOException;
import java.util.Scanner;

public final class App {
    private TerminalType terminalType = TerminalType.Default;
    public TerminalType getTerminalType(){
        return terminalType;
    }
    public void resolve(String input) throws IOException {
        String[] args =input.trim().split("\\s+");
        terminalType=Global.getInstance().status;
        if(args.length !=0){
            switch (terminalType){
                case Default: Default.getTerminal().run(args);
                    break;
                case Sudo: Sudo.getTerminal().run(args);
                    break;
                case QUIT:
            }
        }
        terminalType=Global.getInstance().status;
    }
    public static void run() {
        Scanner scan = new Scanner(System.in);
        String input;
        App app = new App();
        while (scan.hasNextLine()) {
            input = scan.nextLine().trim();
            try {
                app.resolve(input);
            }catch (Exception e){
                System.out.println(input);
            }
            if(app.getTerminalType()==TerminalType.QUIT){
                System.exit(0);
            }
        }
    }
}

package controller.role;

import behavior.ErrorBehavior;
import behavior.role.CertBehavior;

public class CertController {
    public static void ImportCert(String[] args) {
        if(args.length!=2){
            ErrorBehavior.ArgIllegal();
        }
        else {
            CertBehavior.importCert(args);
        }
    }
}

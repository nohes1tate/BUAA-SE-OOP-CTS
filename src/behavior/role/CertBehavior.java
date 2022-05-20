package behavior.role;

import behavior.ErrorBehavior;
import entity.user.Cert;

import java.io.BufferedReader;
import java.io.FileReader;

public class CertBehavior {
    public static void importCert(String[] args) {
        String fileName = args[1];
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(",");
                Cert.importCert(lines);
            }
            br.close();
            System.out.printf("Import Success, Positive:%d Negative:%d%n", Cert.getP(), Cert.getN());
        } catch (Exception e){
            ErrorBehavior.UnError();
        }
    }
}

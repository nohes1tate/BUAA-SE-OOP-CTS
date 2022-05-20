package entity.user;

import java.util.HashMap;

public class Cert {
    private static HashMap<String,Boolean> cert = new HashMap<>();
    private Cert(){}
    private static int P,N;
    public static void importCert(String[] args){
        boolean res = args[1].equals("N");
        if(cert.containsKey(args[0])){
            if(cert.get(args[0])){
                N--;
            }else {
                P--;
            }
        }
        cert.put(args[0],res);
        if(res){
            N++;
        }
        else {
            P++;
        }
    }
    public static boolean getCert(String aadhaar){
        if(cert.get(aadhaar)==null)
        return false;
        return cert.get(aadhaar);
    }

    public static int getN() {
        return N;
    }

    public static int getP() {
        return P;
    }
}

package ftpServer;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Serveur FTP
 */
public class FtpServer {

    public static int counter; // serveur compteur qui enregiste le nombre total de requete
    public static String initDir; // repertoire initial ou on lance notre prog
    public static ArrayList users = new ArrayList(); // état des user courant
    public static ArrayList usersInfo = new ArrayList(); // état détail des user

    public FtpServer() {

        System.out.println("Starting server on 127.0.0.1:20000...");
        // UserInfos

        usersInfo.add(UserInfos.loadUsersInfo("root","root","/tmp"));
        usersInfo.add(UserInfos.loadUsersInfo("toto","root","/home"));

        // Counter pour accueil le nème user
        int counter = 1;
        int i = 0;
        try {

            // écouter les demandes de connexion sur un port TCP > 1023
            ServerSocket s = new ServerSocket(20000);
            for (;;) {
                Socket incoming = s.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        incoming.getInputStream()));
                PrintWriter out = new PrintWriter(incoming.getOutputStream(),
                        true);
                out.println("220 Service ready for new user," + counter);

                // create thread pour nouveau user
                FtpRequest h = new FtpRequest(incoming, i);
                h.start();

                // ajouter dans user courant
                users.add(h);
                counter++;
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // FtpServer() end

    /**
     * main fonction
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            initDir = args[0];
        } else {
            initDir = "/tmp";
        }
        FtpServer ftpServer = new FtpServer();

    } // main end
}

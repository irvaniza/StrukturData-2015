import java.net.Socket;
import java.net.UnknownHostException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class UtamaServer {
    public static void main(String[] args)
    throws UnknownHostException, IOException {
        Server server = new Server();
        server.dengar();
    }
}
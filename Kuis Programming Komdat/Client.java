import java.net.Socket;
import java.net.InetAddress;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Client {    
    /**
     * Constructor
     * 1. Buka socket
     * 2. Ambil Input dan Output stream-nya
     * 3. Ubah Stream-nya ke Reader dan Writer
     */
    public Client(String ipStr, int port) 
           throws IOException {
        // Buka socket
        InetAddress ip = InetAddress.getByName(ipStr);
        koneksi = new Socket(ip, port);

        // Minta stream untuk tulis
        keluaran = koneksi.getOutputStream();
        keluaranWriter = new BufferedWriter(new OutputStreamWriter(keluaran)); 
        
        // Minta stream untuk baca
        masukan = koneksi.getInputStream();
        masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
    }
    
    /**
     * Kirim satu perintah ke server dan tampung balasannya.
     * Akan mengembalikan balasan dari server berupa String.
     */
    public String perintah(String perintah) throws IOException {
        String balasan = null;
        
        // Kirim perintah ke server
        keluaranWriter.write(perintah, 0, perintah.length());               
        keluaranWriter.newLine();
        keluaranWriter.flush();
        
        // Baca balasan
        if (perintah.compareTo("SIAPA") == 0) {
            // Baca balasan dari server        
            balasan = masukanReader.readLine();
            while (balasan == null) {
                // coba terus sampai ada balasan
                balasan = masukanReader.readLine();
            }
        }
        
        else if (perintah.compareTo("WAKTU") == 0) {
            // Baca balasan dari server        
            balasan = masukanReader.readLine();
            while (balasan == null) {
                // coba terus sampai ada balasan
                balasan = masukanReader.readLine();
            }
        }
        
        else {
            // Baca balasan dari server        
            balasan = masukanReader.readLine();
            while (balasan == null) {
                // coba terus sampai ada balasan
                balasan = masukanReader.readLine();
            }
        }

        return balasan;
    }
    
    /**
     * Tutup koneksi ke server
     */
    public void tutup() throws IOException {
        koneksi.close();
    }
    
    // Socket ke server
    private Socket koneksi;
    // Stream untuk menulis perintah
    private OutputStream keluaran;
    // Writer untuk stream untuk menulis perintah
    private BufferedWriter keluaranWriter;
    // Stream untum membaca balasan dari server
    private InputStream masukan;
    // Reader untuk stream membaca balasan dari server
    private BufferedReader masukanReader;        
}

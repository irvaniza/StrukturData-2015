import java.net.Socket;

import java.net.UnknownHostException;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void chat()
    throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);
        
        try {
            //Masukkan pesan
            Scanner input = new Scanner(System.in);
            System.out.print("Pesan : ");
            String isiPesan = input.nextLine();
            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(isiPesan);
            keluaranBuff.write("\n");
            keluaranBuff.flush();
            // Baca dari Server
            System.out.print("Dari server : ");
            Reader masukan = new InputStreamReader(socket.getInputStream());
            BufferedReader masukanBuff = new BufferedReader(masukan);
            String balasan = masukanBuff.readLine();
            System.out.println(balasan);
            //Ubah balasan dari server dalam bentuk upper case
            balasan = balasan.toUpperCase();
            // Tulis kembali ke socket
            keluaranBuff.write(balasan);
            keluaranBuff.flush();
        }
        catch(IOException e) {
            System.out.println(e);
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
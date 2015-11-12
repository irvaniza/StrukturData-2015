import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge
{
    /**
     * Constructor for objects of class Merge
     */
    public void merge(String file1, String file2, String file3, String sasaran) throws IOException
    {
        FileInputStream masukan1 = null;
        FileInputStream masukan2 = null;
        FileInputStream masukan3 = null;
        FileOutputStream keluaran = null;
    
        try { 
            masukan1 = new FileInputStream(file1);
            masukan2 = new FileInputStream(file2);
            masukan3 = new FileInputStream(file3);
            keluaran = new FileOutputStream(sasaran);
            int karakter1 = masukan1.read();
            int karakter2 = masukan2.read();
            int karakter3 = masukan3.read();
            
            while (karakter1 != -1) {
                keluaran.write(karakter1);
                karakter1 = masukan1.read();
            }
            
            while (karakter2 != -1) {
                karakter2=Character.toUpperCase(karakter2);
                keluaran.write(karakter2);
                karakter2 = masukan2.read();
            }
            
            while (karakter3 != -1) {
                keluaran.write(karakter3);
                karakter3 = masukan3.read();
            }
            
            keluaran.flush();
            }
            
            catch (IOException kesalahan) {
                System.out.printf("Terjadi kesalahan: %s", kesalahan);
            }
            
            finally {
            // Tutup stream masukan
            if (masukan1 != null && masukan2 != null && masukan3 != null) {
                masukan1.close();
                masukan2.close();
                masukan3.close();
            } 
            
            if (keluaran != null) {
                keluaran.close();
            }
            }
    }
}

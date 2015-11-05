
/**
 * Write a description of class Pool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pool 
{
    private Kendaraan[] kendaraan;
    
    public Pool (Kendaraan[] kendaraan){
        this.kendaraan = kendaraan;
        if (this.kendaraan == null) {
            this.kendaraan= new Kendaraan[0];
        }
    }
    
    public int jumlah(){
        return kendaraan.length;
    }
    
    public Kendaraan[] daftarKendaraan(){
        return kendaraan;
    }
    
}

/**
 * Write a description of class Becak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Becak implements Kendaraan
{
    private String plat;
    public Becak (String plat){
        this.plat=plat;
    }
    
    public String plat(){
        return plat;
    }
    
    public String tipe(){
        return ("Becak");
    }
}

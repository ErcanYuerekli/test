
import java.util.ArrayList;
import java.util.Arrays;

public class Fahrzeug {

    private static ArrayList<String>  autos= new ArrayList<String>();
    private static ArrayList<String>  motorraeder= new ArrayList<String>();
    static int idAuto = 1;
    static int idMotorrad = 1;
    
    
    public Fahrzeug() {
    }


    public static void vergebenAutoID(String x){
        autos.add(x + idAuto++);
    }
    public static void vergebenMotorradID(String x){
        motorraeder.add(x + idMotorrad++);
    }

    public static ArrayList<String> getAutos() {
        return autos;
    }

    public static ArrayList<String> getMotorraeder() {
        return motorraeder;
    }
}

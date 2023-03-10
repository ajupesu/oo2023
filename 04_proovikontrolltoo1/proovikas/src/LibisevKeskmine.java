import java.util.ArrayList;
import java.util.List;

public class LibisevKeskmine {

    List<Double> arvudListis = new ArrayList<>();
    List<Double> arvudKeskmisega = new ArrayList<>();
    public LibisevKeskmine(double nr1, double nr2, double nr3){
        arvudListis.add(nr1);
        arvudListis.add(nr2);
        arvudListis.add(nr3);
    }
    public void lisaArv(double arv){
        arvudListis.add(arv);
        for (int i = arvudKeskmisega.size(); i < arvudListis.size()-2; i++) {
            double keskmine = (arvudListis.get(i)+ arvudListis.get(i+1) + arvudListis.get(i+2)) / 3;
            arvudKeskmisega.add(keskmine);
        }
    }
}

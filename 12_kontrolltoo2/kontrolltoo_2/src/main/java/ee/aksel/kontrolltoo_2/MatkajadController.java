package ee.aksel.kontrolltoo_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ee.aksel.kontrolltoo_2.MatkaradaController.matkarajad;

@RestController
public class MatkajadController {
    static List<Matkajad> matkajad = new ArrayList<>(Arrays.asList(
            new Matkajad(1, "Andrus",5.5,matkarajad),
            new Matkajad(2,"Kaarel",6.7,matkarajad)
    ));

    @GetMapping("matkajad")
    public List<Matkajad> getMatkajad(){
        return matkajad;
    }

    @GetMapping("lisa-matkaja")
    public List<Matkajad> addMatkajaURL(
            @RequestParam int id,
            @RequestParam String nimi,
            @RequestParam double kilometraaz){
        matkajad.add(new Matkajad(id, nimi, kilometraaz));
        return (List<Matkajad>) matkajad;
    }  // localhost:8080/lisa-matkaja?id=3&nimi=Liisa&kilometraaz=8.5

    @GetMapping("muuda-kilometraazi")
    public String muudaKilometraaz(
            @RequestParam int id,
            @RequestParam Double uusKilometraaz) {
        for (Matkajad matkaja : matkajad) {
            if (matkaja.getId() == id) {
                matkaja.setKilometraaz(uusKilometraaz);
                return "muutsid" + matkaja.getNimi() + "kilometraazi";
            }
        }
        return "error";
    } //http://localhost:8080/muuda-kilometraazi?id=1&uusKilometraaz=10.0
}

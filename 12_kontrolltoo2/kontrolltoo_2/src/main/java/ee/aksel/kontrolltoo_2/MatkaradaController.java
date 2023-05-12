package ee.aksel.kontrolltoo_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ee.aksel.kontrolltoo_2.MatkajadController.matkajad;


@RestController
public class MatkaradaController {

    static List<Matkarada> matkarajad = new ArrayList<>(Arrays.asList(
            new Matkarada(1,"tartu",5.5,new ArrayList<Matkajad>()),
            new Matkarada(2,"parnu",7.6,new ArrayList<Matkajad>())
    ));

    @GetMapping("matkarada/{id}/matkajad")
    public int getMatkajadCount(@PathVariable int id) {
        Matkarada matkarada = getMatkaradaById(id);
        if (matkarada != null) {
            return matkarada.getMatkajad().size();
        }
        return -1; // or throw an exception
    }

    @GetMapping("matkarada/{id}/kilometraaz")
    public Double getMatkajadKilometraaz(@PathVariable int id) {
        Matkarada matkarada = getMatkaradaById(id);
        if (matkarada != null) {
            Double totalKilometraaz = 0.0;
            for (Matkajad matkaja : matkarada.getMatkajad()) {
                totalKilometraaz += matkaja.getKilometraaz();
            }
            return totalKilometraaz;
        }
        return -1.0; // or throw an exception
    }

    private Matkarada getMatkaradaById(int id) {
        for (Matkarada matkarada : matkarajad) {
            if (matkarada.getId() == id) {
                return matkarada;
            }
        }
        return null;
    }
}


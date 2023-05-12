package ee.aksel.kontrolltoo_2;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Matkajad {
    @Id
    private int id;
    private String nimi;
    private Double kilometraaz;
    @ManyToMany
    private List<Matkarada> matkarajad = new ArrayList<>();

    public Matkajad(int id, String nimi, double kilometraaz) {
    }
}

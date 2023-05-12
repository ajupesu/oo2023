package ee.aksel.kontrolltoo_2;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Matkarada {
    @Id
    private int id;
    private String nimetus;
    private Double pikkus;
    @ManyToMany(mappedBy = "matkarajad")
    private List<Matkajad> matkajad = new ArrayList<>();
}

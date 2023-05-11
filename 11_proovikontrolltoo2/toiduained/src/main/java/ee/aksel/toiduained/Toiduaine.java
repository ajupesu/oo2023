package ee.aksel.toiduained;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Toiduaine {
    @Id
    private Long id;
    private String nimetus;
    private int valk;
    private int rasv;
    private int sysivesik;
}

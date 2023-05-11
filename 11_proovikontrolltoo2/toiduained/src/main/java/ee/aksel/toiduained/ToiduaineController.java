package ee.aksel.toiduained;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToiduaineController {
    @Autowired //andmebaasi
    ToiduaineRepository toiduaineRepository;
    // localhost:8080/lisa-toiduaine?id=1&nimetus=kartul&valk=5&rasv=2&sysivesik=93       @RequestParam
    @Autowired
    ToidukomponentRepository toidukomponentRepository;

    //localhost:8080/leia-rasva-alusel?alg=1&l6pp=5
    @GetMapping("leia-rasva-alusel")
    public List<Toiduaine> leiaRasvaAlusel(
            @RequestParam int alg,
            @RequestParam int l6pp
    ){
        return toiduaineRepository.findByRasvIsBetween(alg, l6pp);
    }

    // localhost:8080/leia-nime-alusel?nimetus=kartul
    @GetMapping("leia-nime-alusel")
    public Toiduaine leiaNimeAlusel(
            @RequestParam String nimetus
    ){
        return toiduaineRepository.findByNimetus(nimetus);
    }

    // localhost:8080/leia-nime-alusel2?nimetus=kartul
    @GetMapping("leia-nime-alusel2")
    public Toiduaine leiaNimeAlusel2(
            @RequestParam String nimetus
    ) {
        List<Toiduaine> toiduained = toiduaineRepository.findAll();
        for (int i = 0; i < toiduained.size(); i++) {
            if (toiduained.get(i).getNimetus().equals(nimetus)) {
                return toiduained.get(i);
            }
        }
        return null;
    }

    @DeleteMapping("kustuta-toiduaine")
    public List<Toiduaine> kustutaToiduaine(
            @RequestParam Long id
    ){
        toiduaineRepository.deleteById(id);
        return toiduaineRepository.findAll();
    }

    // localhost:8080/saa-rasv?id=1
    @GetMapping("saa-rasv")
    public int saaRasv(
            @RequestParam Long id
    ){
        Toidukomponent toidukomponent = toidukomponentRepository.findById(id).get();
        int rasv = toidukomponent.getToiduaine().getRasv() * toidukomponent.getKogus() / 100;
        return rasv;
    }
    // localhost:8080/lisa-toidukomponent?id=1&toiduaineId=1&kogus=100
    @GetMapping("lisa-toidukomponent")
    public List<Toidukomponent> lisaToidukomponent(
            @RequestParam Long id,
            @RequestParam Long toiduaineId,
            @RequestParam int kogus
    ){
        Toiduaine toiduaine = toiduaineRepository.findById(toiduaineId).get();
        toidukomponentRepository.save(new Toidukomponent(id, toiduaine, kogus));
        return toidukomponentRepository.findAll();
    }
    @GetMapping("lisa-toiduaine")
    public List<Toiduaine> lisaToiduaine(
            @RequestParam Long id,
            @RequestParam String nimetus,
            @RequestParam int valk,
            @RequestParam int rasv,
            @RequestParam int sysivesik
    ) throws Exception {
        if(valk + rasv + sysivesik > 100){
            throw new Exception("Protsent ei saa olla üle 100%!");
        }
        toiduaineRepository.save(new Toiduaine(id, nimetus, valk, rasv, sysivesik));
        return toiduaineRepository.findAll();
    }
}

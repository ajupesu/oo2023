package ee.aksel.toiduained;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToitController {
    @Autowired
    ToitRepository toitRepository;

    @GetMapping("toidu-valgud")
    public int toiduValgud(
            @RequestParam String nimetus
    ){
        Toit toit = toitRepository.findById(nimetus).get();
        List<Toidukomponent> toidukomponendid = toit.getToidukomponendid();
        int valk = 0;
        for (Toidukomponent t: toidukomponendid){
            valk += t.getToiduaine().getValk()*t.getKogus()/100;
        }
        return valk;
    }

    @GetMapping("toidu-rasvad")
    public int toiduRasvad(
            @RequestParam String nimetus
    ){
        Toit toit = toitRepository.findById(nimetus).get();
        List<Toidukomponent> toidukomponendid = toit.getToidukomponendid();
        int rasv = 0;
        for (Toidukomponent t: toidukomponendid){
            rasv += t.getToiduaine().getRasv()*t.getKogus()/100;
        }
        return rasv;
    }

    @GetMapping("toidu-sysivesikud")
    public int toiduSysivesikud(
            @RequestParam String nimetus
    ){
        Toit toit = toitRepository.findById(nimetus).get();
        List<Toidukomponent> toidukomponendid = toit.getToidukomponendid();
        int sysivesik = 0;
        for (Toidukomponent t: toidukomponendid){
            sysivesik += t.getToiduaine().getSysivesik()*t.getKogus()/100;
        }
        return sysivesik;
    }

    @GetMapping("saa-toiduained")
    public List<Toiduaine> saaToiduAined(
            @RequestParam String nimetus
    ){
        Toit toit = toitRepository.findById(nimetus).get();
        List<Toidukomponent> toidukomponendid = toit.getToidukomponendid();
        int kogus = 0;
        for (Toidukomponent t: toidukomponendid){
            kogus += t.getKogus();
        }

        return new ArrayList<>();
    }
}
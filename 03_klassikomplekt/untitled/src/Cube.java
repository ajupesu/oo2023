public class Cube {
    Info info;

    String nimi;

    public Cube(Info info, String nimi) {
        this.info = info;
        this.nimi = nimi;
    }
    public void muudaNime(String uusNimi){
        nimi = uusNimi;
    }
}

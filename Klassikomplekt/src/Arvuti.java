public class Arvuti {
    Info info;

    double maksumus;

    public Arvuti(Info info, double maksumus) {
        this.info = info;
        this.maksumus = maksumus;
    }
    public void seadistaInfo(Info info) {
        this.info = info;
    }
}

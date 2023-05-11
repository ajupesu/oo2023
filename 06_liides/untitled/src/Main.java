public class Main {
    public static void main(String[] args) {
         Auto id1 = new Auto(100000, 1980,2,"Mercedes");
        System.out.println("Price: " + id1.getPriceForCar() + " KW: " + id1.getKWfromEngineSize());
        Auto id2 = new Auto(423004, 2020, 4.8,"Volkswagen");
        System.out.println("Price: " + id2.getPriceForCar() + " KW: " + id2.getKWfromEngineSize());
        Auto id3 = new Auto(600100, 1985, 2.5,"Toyota");
        System.out.println("Price: " + id3.getPriceForCar() + " KW: " + id3.getKWfromEngineSize());
        Auto id4 = new Auto(12000, 2022, 3.5,"Audi");
        System.out.println("Price: " + id4.getPriceForCar()+ " KW: " + id4.getKWfromEngineSize());
        Auto id5 = new Auto(300230, 2009, 1.8,"Dacia");
        System.out.println("Price: " + id5.getPriceForCar() + " KW: " + id5.getKWfromEngineSize());
        Auto id6 = new Auto(299992, 2010, 3.2,"BMW" );
        System.out.println("Price: " + id5.getPriceForCar() + " KW: " + id6.getKWfromEngineSize());
        Traktor id7 = new Traktor(70000, 1990, 8, "john deer");
        System.out.println("Price: " + id7.getPriceForTractor() + " KW: " + id7.getKWfromEngineSize());
    }
}
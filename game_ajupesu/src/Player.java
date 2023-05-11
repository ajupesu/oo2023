public class Player {
    int xCoordinate;
    int yCoordinate;
    char symbol;
    Direction direction; //3nda tunni teema

    Item item; // klassikomplekt  Player klassi sees on Item klass

    // constructor
    // peab olema klassi nimega ja public!
    // constructor on funktsioon, mis käivitatakse koheselt, kui tehakse new Player();
    // muutujad võib enne konstruktorit deklareerida, kuid väärtus tavaliselt antakse konstruktori sees
    public Player(int worldWidth, int worldHeight){
        // TÖÖTAKS KA ILMA this kasutamata, kuid this kasutamine on konventsioon
        // this näitab ära, et kasutab üleval loodud Player klassi xCoordinate
        this.xCoordinate = getRandomCoordinate(worldWidth);
        // täpselt sama on ka siin, kus this näitab, et kasutab üleval loodud int yCoordinate muutujat
        this.yCoordinate = getRandomCoordinate(worldHeight);
        this.symbol = 'X';
        this.direction = Direction.UP;
    }

    private static int getRandomCoordinate(int worldDimension) {
        // castimine ehk teisendamine ühest tüübist teise
        return (int) (Math.random() * (worldDimension - 2) + 1);
    }

    // public tähendab, et mõni teine klass saab ka seda funktsiooni välja kutsuda
    // private tähendab, et seda funktsiooni saab ainult selles klassis kasutada
    public void move(String input, World world) { //siin World world parameetri kaasa saatmine ei ole programmile lisakoormus
        // See on lihtsalt mälu ümber paigutamine. Isegi, et tegemist on suure objektia. Mälu probleem tekib uute objektide loomisel!
        if (input.equals("w")) {
            this.direction = Direction.UP;
        } else if (input.equals("s")) {
            this.direction = Direction.DOWM;
        } else if (input.equals("a")) {
            this.direction = Direction.LEFT;
        } else if (input.equals("d")) {
            this.direction = Direction.RIGHT;
        }
        if (direction.equals(Direction.UP) && this.yCoordinate > 1) { //siin suurem ühest, et y-teljel ei läheks alla 0
            this.yCoordinate = this.yCoordinate - 1;
        } else if (direction.equals(Direction.DOWM) && this.yCoordinate < world.height-2) { //Siin väiksem kui world.height-1, et ei läheks piirjoonest välja
            this.yCoordinate = this.yCoordinate + 1;
        } else if (direction.equals(Direction.LEFT) && this.xCoordinate > 1) { //siin suurem ühest, et x-teljel ei läheks alla 0
            this.xCoordinate = this.xCoordinate - 1;
        } else if (direction.equals(Direction.RIGHT) && this.xCoordinate < world.width-2) { //Siin väiksem kui world.width-1, et ei läheks piirjoonest välja
            this.xCoordinate = this.xCoordinate + 1;
        }
    }
}
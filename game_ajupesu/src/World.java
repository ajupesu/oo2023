import java.util.List;

public class World {
    int width;
    int height;

    public World(int width, int height){
        this.width = width;
        this.height = height;
    }
    public void printMap(int worldWidth, int worldHeight,
                         int playerXCoordinate, int playerYCoordinate, char playerSymbol,
                         int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol,
                         int orcXCoordinate, int orcYCoordinate, char orcSymbol, List<Item> items) {
        char symbol; // luuakse uus muutuja (deklareerimine), esmakordne vaartuse andmine on initsialiseerimine
        for (int y = 0; y < worldHeight; y++) {
            System.out.println();
            for (int x = 0; x < worldWidth; x++) {
                if (y == 0 || y == worldHeight -1) {
 //                  System.out.print("-");
                    symbol = '-';
                } else if (x == 0 || x == worldWidth -1) {
  //                  System.out.print("|");
                    symbol ='|';
                } else {
                    // ctrl + alt + m
                    // parem klõps -> refactor -> extract method
                    symbol = printCharacters(playerXCoordinate, playerYCoordinate, playerSymbol, dragonXCoordinate,
                            dragonYCoordinate, dragonSymbol, orcXCoordinate, orcYCoordinate, orcSymbol, y, x);
                    for (Item i: items){
                        if (i.yCoordinate == y && i.xCoordinate == x){
 //                           System.out.println("I");
                            symbol ='I';
                            break;
                        }
                    }
                    System.out.println(symbol);
                }
            }
        }
    }

//    private static int getRandomCoordinate(int worldDimension) {
//        return (int) (Math.random() * (worldDimension - 2) + 1);
//    }

    private char printCharacters(int playerXCoordinate, int playerYCoordinate, char playerSymbol,
                                 int dragonXCoordinate, int dragonYCoordinate, char dragonSymbol, int orcXCoordinate,
                                 int orcYCoordinate, char orcSymbol, int mapY, int mapX) {
        if (playerXCoordinate == mapX && playerYCoordinate == mapY) { // aktiveerin -> parem klõps -> refactor -> rename (muudab kõik muutujad allapool korraga)
//            System.out.print(playerSymbol);
            return playerSymbol;
        } else if (dragonXCoordinate == mapX && dragonYCoordinate == mapY) {
//            System.out.print(dragonSymbol);
            return dragonSymbol;
        } else if (orcXCoordinate == mapX && orcYCoordinate == mapY) {
//            System.out.print(orcSymbol);
            return orcSymbol;
        } else {
//            System.out.print(" ");
            return ' ';
        }
    }
}

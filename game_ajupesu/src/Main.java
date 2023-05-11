import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //String sonaline = "sõnaline muutuja";
        //char taheline = 'c';
        //double komakohaga = 341.432321;
        //float komakohaga2 = 4321.23541F; // Ei kasutata väga
        //boolean kahendv22rtus = true; // 0 ja 1
        //byte pisikeNumber = 127; // väiksem arv, kuni 127
        //short lyhikeNumber = 32767; // kuni 32767
        //long pikkNumber = 124235423598765L; //Kui on liiga pikk (punane joon all), siis tuleb 'L' lõppu panna

        Scanner scanner = new Scanner(System.in); //.in on konstruktor
        // muutuja scanner sai enda sisse kõik omadused mis on Scanner klassi sees
        // cmd + hiire klikk  avab Scanneri klassi
        /*String input = scanner.nextLine();*/
        // kursorit peal hoides .nextLine(), näame funktsiooni lühikirjeldust ,ning et funktsioon returnib String andmetüübi
        // sellepärast me ei saagi salvestada seda teise andemtääbi muutuja sisse (nagu näiteks int, double jne.)
        /*double proovInput = scanner.nextLine();*/ // Kuna returnitav andmetääp on String, siis IntelliJ toob errori

        World world = new World(15, 7);

        // Nagu ennem kirjas siin siin muutuja player sai kõik Player klassi omadused
        Player player = new Player(world.width, world.height);
        Dragon dragon = new Dragon(world.width, world.height);
        Orc orc = new Orc(world.width, world.height);

        Item sword = new Item(10, 1,"Mõõk", world.width, world.height);
        Item hammer = new Item(5, 3,"Haamer", world.width, world.height);
        Item boot = new Item(1, 10,"Saabas", world.width, world.height);

        //import! java.util.list
        //import: java.util.Arraylist
        //import: arrays
        //List--> muudetav
        List<Item> items = new ArrayList<>(Arrays.asList(sword, hammer, boot));

        // Item[] items1 = {sword, hammer, boot};

        world.printMap(world.width, world.height,
                player.xCoordinate, player.yCoordinate, player.symbol,
                dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                orc.xCoordinate, orc.yCoordinate, orc.symbol, items);
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            player.move(input, world);
            //switch (input) {
            //    case "w" -> playerYCoordinate = playerXCoordinate - 1;
            //    case "s" -> playerYCoordinate = playerYCoordinate + 1;
            //    case "a" -> playerXCoordinate = playerXCoordinate - 1;
            //    case "d" -> playerXCoordinate = playerXCoordinate + 1;
            //}
            world.printMap(world.width, world.height,
                    player.xCoordinate, player.yCoordinate, player.symbol,
                    dragon.xCoordinate, dragon.yCoordinate, dragon.symbol,
                    orc.xCoordinate, orc.yCoordinate, orc.symbol, items);
            System.out.println();
            input = scanner.nextLine();
        }
    }
}
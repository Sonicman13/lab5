import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

public class Store {
    String name;
    String adress;
    int numberOfItems;
    static int maxNumberOfItems = 10;
    int numberOfGames;
    int numberOfPlatforms;
    ArrayList<Item> item = new ArrayList<Item>();
    ArrayList<Game> game = new ArrayList<Game>();
    ArrayList<Platform> platform = new ArrayList<Platform>();
    void read(){
        int f,i;
        Item[] item1 = new Item[10];
        Game[] game1 = new Game[10];
        Platform[] platform1 = new Platform[10];
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        System.out.println("Введите название магазина");
        name = in.nextLine();
        System.out.println("Введите адрес магазина");
        adress = in.nextLine();
        System.out.println("Добавить товар(1 - да, 0 - нет)");
        f = in.nextInt();
        i = 0;
        while(f == 1 && i < maxNumberOfItems){
            item1[i] = new Item();
            item1[i].read();
            item.add(item1[i]);
            i++;
            System.out.println("Добавить товар(1 - да, 0 - нет)");
            f = in.nextInt();
        }
        numberOfItems = i;
        System.out.println("Добавить игру(1 - да, 0 - нет)");
        f = in.nextInt();
        i = 0;
        while(f == 1){
            game1[i] = new Game();
            game1[i].read(1);
            game.add(game1[i]);
            i++;
            System.out.println("Добавить игру(1 - да, 0 - нет)");
            f = in.nextInt();
        }
        numberOfGames = i;
        System.out.println("Добавить консоль(1 - да, 0 - нет)");
        f = in.nextInt();
        i = 0;
        while(f == 1){
            platform1[i] = new Platform();
            platform1[i].read(1);
            platform.add(platform1[i]);
            i++;
            System.out.println("Добавить консоль(1 - да, 0 - нет)");
            f = in.nextInt();
        }
        numberOfPlatforms = i;
    }
    Store(String name1, String adress1, int numberOfItems1, Item item1[], int numberOfGames1, Game[] game1, int numberOfPlatforms1, Platform[] platform1){
        if(numberOfItems1 <= maxNumberOfItems){
            name = name1;
            adress = adress1;
            numberOfItems = numberOfItems1;
            for(numberOfItems1 = 0; numberOfItems1 < numberOfItems; numberOfItems1++){
                item.add(item1[numberOfItems1]);
            }
            numberOfGames = numberOfGames1;
            for(numberOfGames1 = 0; numberOfGames1 < numberOfGames; numberOfGames1++){
                game.add(game1[numberOfGames1]);
            }
            numberOfPlatforms = numberOfPlatforms1;
            for(numberOfPlatforms1 = 0; numberOfPlatforms1 < numberOfPlatforms; numberOfPlatforms1++){
                platform.add(platform1[numberOfPlatforms1]);
            }
        }
    }
    Store(String name1){
        name = name1;
        adress = "-";
        numberOfItems = 0;
        numberOfGames = 0;
        numberOfPlatforms = 0;
    }
    Store(){
        name = "-";
        adress = "-";
        numberOfItems = 0;
        numberOfGames = 0;
        numberOfPlatforms = 0;
    }
    void display(){
        int i;
        System.out.println("Название магазина:" + name);
        System.out.println("Адрес магазина:" + adress);
        System.out.println("Колличество товаров:" + numberOfItems);
        System.out.println("Колличество мест для товаров:" + maxNumberOfItems);
        for(i = 0;i < numberOfItems; i++){
            System.out.println("Товар:" + (i+1));
            item.get(i).display();
        }
        for (i = 0; i < numberOfGames; i++)
        {
            System.out.println("Игра " + (i + 1));
            game.get(i).display();
        }
        for (i = 0; i < numberOfPlatforms; i++)
        {
            System.out.println("Консоль " + (i + 1));
            platform.get(i).display();
        }
    }
    void add(){
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        int f;
        System.out.println("Добавить товар (1), игру (2) или консоль (3)");
        f = in.nextInt();
        if(f == 1){
            Item item1 = new Item();
            item1.read();
            item.add(item1);
            numberOfItems++;
        }
        else if(f == 2){
            Game game1 = new Game();
            game1.read(1);
            game.add(game1);
            numberOfGames++;
        }
        else {
            Platform platform1 = new Platform();
            platform1.read(1);
            platform.add(platform1);
            numberOfPlatforms++;
        }
    }
    void priceChange(String code, double price){
        int i, f;
        i = f = 0;
        while(i < numberOfItems){
            if(code.equals(item.get(i).getCode())){
                item.get(i).setPrice(price);
                i = numberOfItems;
                f = 1;
            }
            i++;
        }
        if(f == 0){
            i = 0;
            while(i < numberOfGames){
                if(code.equals(game.get(i).getCode())){
                    game.get(i).setPrice(price);
                    i = numberOfGames;
                    f = 1;
                }
                i++;
            }
        }
        if(f == 0){
            i = 0;
            while(i < numberOfPlatforms){
                if(code.equals(platform.get(i).getCode())){
                    platform.get(i).setPrice(price);
                    i = numberOfPlatforms;
                    f = 1;
                }
                i++;
            }
        }
    }
    void amountChange(String code, int amount){
        int i, f;
        i = f = 0;
        while(i < numberOfItems){
            if(code.equals(item.get(i).getCode())){
                item.get(i).setAmount(amount);
                i = numberOfItems;
            }
            i++;
        }
        if(f == 0){
            i = 0;
            while(i < numberOfGames){
                if(code.equals(game.get(i).getCode())){
                    game.get(i).setAmount(amount);
                    i = numberOfGames;
                    f = 1;
                }
                i++;
            }
        }
        if(f == 0){
            i = 0;
            while(i < numberOfPlatforms){
                if(code.equals(platform.get(i).getCode())){
                    platform.get(i).setAmount(amount);
                    i = numberOfPlatforms;
                    f = 1;
                }
                i++;
            }
        }
    }
    void displayName(){
        System.out.println("Магазин:" + name);
    }
    boolean storecmp(String name1){
       if(name.equals(name1)){
           return true;
       }
       else {
           return false;
       }
    }
    void getNumber(Number k){
        k.number = numberOfItems;
    }
    static void maxNumberOfItemsChange(int newMax){
        maxNumberOfItems = newMax;
    }
    void add(String code)
    {
        int i, f;
        i = f = 0;
        while (i < numberOfGames)
        {
            if (code.equals(game.get(i).getCode()))
            {
                game.get(i).add();
                i = numberOfGames;
                f = 1;
            }
            i++;
        }
        if (f == 0)
        {
            i = 0;
            while (i < numberOfPlatforms)
            {
                if (code.equals(platform.get(i).getCode()))
                {
                    platform.get(i).add();
                    i = numberOfPlatforms;
                    f = 1;
                }
                i++;
            }
        }
    }
    void sortItems(){
        Collections.sort(item);
        Collections.sort(game);
        Collections.sort(platform);
    }
} 
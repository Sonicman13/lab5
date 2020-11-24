import java.util.Scanner;

public class Store {
    String name;
    String adress;
    int numberOfItems;
    static int maxNumberOfItems = 10;
    int numberOfGames;
    int numberOfPlatforms;
    Item[] item = new Item[5];
    Game[] game = new Game[5];
    Platform[] platform = new Platform[5];
    void read(){
        int f,i;
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
            item[i] = new Item();
            item[i].read();
            i++;
            System.out.println("Добавить товар(1 - да, 0 - нет)");
            f = in.nextInt();
        }
        numberOfItems = i;
        System.out.println("Добавить игру(1 - да, 0 - нет)");
        f = in.nextInt();
        i = 0;
        while(f == 1){
            game[i] = new Game();
            game[i].read(1);
            i++;
            System.out.println("Добавить игру(1 - да, 0 - нет)");
            f = in.nextInt();
        }
        numberOfGames = i;
        System.out.println("Добавить консоль(1 - да, 0 - нет)");
        f = in.nextInt();
        i = 0;
        while(f == 1){
            platform[i] = new Platform();
            platform[i].read(1);
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
                item[numberOfItems1] = item1[numberOfItems1];
            }
            numberOfGames = numberOfGames1;
            for(numberOfGames1 = 0; numberOfGames1 < numberOfGames; numberOfGames1++){
                game[numberOfGames1] = game1[numberOfGames1];
            }
            numberOfPlatforms = numberOfPlatforms1;
            for(numberOfPlatforms1 = 0; numberOfPlatforms1 < numberOfPlatforms; numberOfPlatforms1++){
                platform[numberOfPlatforms1] = platform1[numberOfPlatforms1];
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
            item[i].display();
        }
        for (i = 0; i < numberOfGames; i++)
        {
            System.out.println("Игра " + (i + 1));
            game[i].display();
        }
        for (i = 0; i < numberOfPlatforms; i++)
        {
            System.out.println("Консоль " + (i + 1));
            platform[i].display();
        }
    }
    void add(){
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        int f;
        System.out.println("Добавить товар (1), игру (2) или консоль (3)");
        f = in.nextInt();
        if(f == 1){
            item[numberOfItems] = new Item();
            item[numberOfItems].read();
            numberOfItems++;
        }
        else if(f == 2){
            game[numberOfGames] = new Game();
            game[numberOfGames].read(1);
            numberOfGames++;
        }
        else {
            platform[numberOfPlatforms] = new Platform();
            platform[numberOfPlatforms].read(1);
            numberOfPlatforms++;
        }
    }
    void priceChange(String code, double price){
        int i, f;
        i = f = 0;
        while(i < numberOfItems){
            if(code.equals(item[i].getCode())){
                item[i].setPrice(price);
                i = numberOfItems;
                f = 1;
            }
            i++;
        }
        if(f == 0){
            i = 0;
            while(i < numberOfGames){
                if(code.equals(game[i].getCode())){
                    game[i].setPrice(price);
                    i = numberOfGames;
                    f = 1;
                }
                i++;
            }
        }
        if(f == 0){
            i = 0;
            while(i < numberOfPlatforms){
                if(code.equals(platform[i].getCode())){
                    platform[i].setPrice(price);
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
            if(code.equals(item[i].getCode())){
                item[i].setAmount(amount);
                i = numberOfItems;
            }
            i++;
        }
        if(f == 0){
            i = 0;
            while(i < numberOfGames){
                if(code.equals(game[i].getCode())){
                    game[i].setAmount(amount);
                    i = numberOfGames;
                    f = 1;
                }
                i++;
            }
        }
        if(f == 0){
            i = 0;
            while(i < numberOfPlatforms){
                if(code.equals(platform[i].getCode())){
                    platform[i].setAmount(amount);
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
            if (code.equals(game[i].getCode()))
            {
                game[i].add();
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
                if (code.equals(platform[i].getCode()))
                {
                    platform[i].add();
                    i = numberOfPlatforms;
                    f = 1;
                }
                i++;
            }
        }
    }
} 
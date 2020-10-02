import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866"), name1, adress1, nameItem1, code1;
        Scanner in = new Scanner(System.in, encoding);
        Store[] store = new Store[10];
        Item[] item = new Item[10];
        int f, numberOfItems1, amount1, i, max, n;
        double price1;
        System.out.println("Ввести данные через read или init(1 - read, 2 - init)");
        f = in.nextInt();
        if(f == 1){
            store[0] = new Store();
            store[0].read();
        }
        else{
            System.out.println("Введите название магазина");
            name1 = in.nextLine();
            System.out.println("Введите адрес магазина");
            adress1 = in.nextLine();
            System.out.println("Добавить товар(1 - да, 0 - нет)");
            f = in.nextInt();
            i = 0;
            while(f == 1){
                System.out.println("Введите название товара");
                nameItem1 = in.nextLine();
                System.out.println("Введите код товара");
                code1 = in.nextLine();
                System.out.println("Введите цену");
                price1 = in.nextDouble();
                System.out.println("Введите колличество");
                amount1 = in.nextInt();
                item[i] = new Item();
                item[i].init(code1, nameItem1, price1, amount1);
                i++;
                System.out.println("Добавить товар(1 - да, 0 - нет)");
                f = in.nextInt();
            }
            numberOfItems1 = i;
            store[0] = new Store();
            store[0].init(name1, adress1, numberOfItems1, item);
        }
        f = 0;
        i = 0;
        max = 1;
        while(f != 8){
            System.out.println("Введите номер следующего действия");
            System.out.println("1 - показать информацию о магазине");
            System.out.println("2 - добавить новый вид товара");
            System.out.println("3 - изменить цену товара");
            System.out.println("4 - изменить колличество товара");
            System.out.println("5 - Добавить магазин");
            System.out.println("6 - показать все магазины");
            System.out.println("7 - сменить магазин");
            System.out.println("8 - выйти");
            f = in.nextInt();
            in.nextLine();
            if(f == 1){
                store[i].display();
            }
            else if(f == 2){
                store[i].add();
            }
            else if(f == 3){
                System.out.println("Введите код товара");
                code1 = in.nextLine();
                System.out.println("Введите новую цену");
                price1 = in.nextDouble();
                store[i].priceChange(code1, price1);
            }
            else if(f ==4){
                System.out.println("Введите код товара");
                code1 = in.nextLine();
                System.out.println("Введите на сколько изменилось колличество товара(если увеличилость - положительное число, если уменьшилось - отрицательное)");
                amount1 = in.nextInt();
                store[i].amountChange(code1, amount1);
            }
            else if(f == 5){
                store[max] = new Store();
                store[max].read();
                i=max;
                max++;
            }
            else if(f == 6){
                for(n = 0;n < max; n++){
                    store[n].displayName();
                }
            }
            else if(f == 7){
                System.out.println("Введите название магазина");
                name1 = in.nextLine();
                for(n = 0;n < max;n++){
                    if(store[n].storecmp(name1) == 1){
                        i = n;
                        n = max;
                    }
                }
            }
        }    
    }
}
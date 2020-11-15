import java.util.Scanner;
import java.util.*;

public class Item {
    String name;
    String code;
    double price;
    int amount;
    void read() {
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        System.out.println("Введите название товара");
        name = in.nextLine();
        System.out.println("Введите код товара");
        code = in.nextLine();
        try{
            System.out.println("Введите цену");
            price = in.nextDouble();
        }
        catch(Exception e){
            price = 0;
            in.nextLine();
        }
        try{
            System.out.println("Введите колличество");
            amount = in.nextInt();
        }
        catch(Exception e){
            amount = 0;
            in.nextLine();
        }
    }
    Item(String code1, String name1, double price1, int amount1){
        code = code1;
        name = name1;
        price = price1;
        amount = amount1;
    }
    Item(){
        code = "-";
        name = "-";
        price = 0;
        amount = 0;
    }
    void display(){
        System.out.println("Название товара:" + name);
        System.out.println("Код тоара:" + code);
        System.out.println("Цена:" + price);
        System.out.println("Колличество:" + amount);
    }
    void setPrice(double price1){
        price = price1;
    }
    void setAmount(int amount1){
        amount = amount + amount1;
    }
    String getCode(){
        return code;
    }
    int getAmount(){
        return amount;
    }
}
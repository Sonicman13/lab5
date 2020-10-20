import java.util.Scanner;

public class Store {
    String name;
    String adress;
    int numberOfItems;
    Item[] item = new Item[10];
    void read(){
        int f,i;
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        System.out.println("������� �������� ��������");
        name = in.nextLine();
        System.out.println("������� ����� ��������");
        adress = in.nextLine();
        System.out.println("�������� �����(1 - ��, 0 - ���)");
        f = in.nextInt();
        i = 0;
        while(f == 1){
            item[i] = new Item();
            item[i].read();
            i++;
            System.out.println("�������� �����(1 - ��, 0 - ���)");
            f = in.nextInt();
        }
        numberOfItems = i;
    }
    void init(String name1, String adress1, int numberOfItems1, Item item1[]){
        name = name1;
        adress = adress1;
        numberOfItems = numberOfItems1;
        for(numberOfItems1 = 0; numberOfItems1 < numberOfItems; numberOfItems1++){
            item[numberOfItems1] = item1[numberOfItems1];
        }
    }
    void display(){
        int i;
        System.out.println("�������� ��������:" + name);
        System.out.println("����� ��������:" + adress);
        System.out.println("����������� �������:" + numberOfItems);
        for(i = 0;i < numberOfItems; i++){
            System.out.println("�����:" + (i+1));
            item[i].display();
        }
    }
    void add(){
        item[numberOfItems] = new Item();
        item[numberOfItems].read();
        numberOfItems++;
    }
    void priceChange(String code, double price){
        int i = 0;
        while(i < numberOfItems){
            if(code.equals(item[i].getCode())){
                item[i].setPrice(price);
                i = numberOfItems;
            }
            i++;
        }
    }
    void amountChange(String code, int amount){
         int i = 0;
        while(i < numberOfItems){
            if(code.equals(item[i].getCode())){
                item[i].setAmount(amount);
                i = numberOfItems;
            }
            i++;
        }
    }
    void displayName(){
        System.out.println("�������:" + name);
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
} 
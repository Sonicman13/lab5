import java.util.Scanner;

public class Item {
    String name;
    String code;
    double price;
    int amount;
    void read() {
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        System.out.println("������� �������� ������");
        name = in.nextLine();
        System.out.println("������� ��� ������");
        code = in.nextLine();
        System.out.println("������� ����");
        price = in.nextDouble();
        System.out.println("������� �����������");
        amount = in.nextInt();
    }
    void init(String code1, String name1, double price1, int amount1){
        code = code1;
        name = name1;
        price = price1;
        amount = amount1;
    }
    void display(){
        System.out.println("�������� ������:" + name);
        System.out.println("��� �����:" + code);
        System.out.println("����:" + price);
        System.out.println("�����������:" + amount);
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
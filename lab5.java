import java.util.Scanner;

public class lab5 {
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866"), name1, adress1, nameItem1, code1;
        Scanner in = new Scanner(System.in, encoding);
        Store[] store = new Store[10];
        Item[] item = new Item[10];
        int f, numberOfItems1, amount1, i, max, n;
        double price1;
        System.out.println("������ ������ ����� read ��� init(1 - read, 2 - init)");
        f = in.nextInt();
        if(f == 1){
            store[0] = new Store();
            store[0].read();
        }
        else{
            System.out.println("������� �������� ��������");
            name1 = in.nextLine();
            System.out.println("������� ����� ��������");
            adress1 = in.nextLine();
            System.out.println("�������� �����(1 - ��, 0 - ���)");
            f = in.nextInt();
            i = 0;
            while(f == 1){
                System.out.println("������� �������� ������");
                nameItem1 = in.nextLine();
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                System.out.println("������� ����");
                price1 = in.nextDouble();
                System.out.println("������� �����������");
                amount1 = in.nextInt();
                item[i] = new Item();
                item[i].init(code1, nameItem1, price1, amount1);
                i++;
                System.out.println("�������� �����(1 - ��, 0 - ���)");
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
            System.out.println("������� ����� ���������� ��������");
            System.out.println("1 - �������� ���������� � ��������");
            System.out.println("2 - �������� ����� ��� ������");
            System.out.println("3 - �������� ���� ������");
            System.out.println("4 - �������� ����������� ������");
            System.out.println("5 - �������� �������");
            System.out.println("6 - �������� ��� ��������");
            System.out.println("7 - ������� �������");
            System.out.println("8 - �����");
            f = in.nextInt();
            in.nextLine();
            if(f == 1){
                store[i].display();
            }
            else if(f == 2){
                store[i].add();
            }
            else if(f == 3){
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                System.out.println("������� ����� ����");
                price1 = in.nextDouble();
                store[i].priceChange(code1, price1);
            }
            else if(f ==4){
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                System.out.println("������� �� ������� ���������� ����������� ������(���� ������������ - ������������� �����, ���� ����������� - �������������)");
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
                System.out.println("������� �������� ��������");
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
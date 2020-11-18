import java.util.Scanner;
import java.util.*;

public class lab5 {
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866"), name1, adress1, nameItem1, code1, f;
        Scanner in = new Scanner(System.in, encoding);
        Store[][] store = new Store[5][10];
        Item[] item = new Item[10];
        Number k = new Number();
        int numberOfItems1, amount1, i, max, n, i1;
        int[] max1 = new int[10];
        double price1;
        System.out.println("������ ������ ����� read ��� init(1 - read, 2 - init)");
        f = in.nextLine();
        if(f.equals("1")){
            store[0][0] = new Store();
            store[0][0].read();
        }
        else{
            System.out.println("������ ��� ��������� (1), ������ ������ �������� (2), �� ������� ��������� (3)");
            f = in.nextLine();
            if(f.equals("1")){
                System.out.println("������� �������� ��������");
                name1 = in.nextLine();
                System.out.println("������� ����� ��������");
                adress1 = in.nextLine();
                System.out.println("�������� �����(1 - ��, 0 - ���)");
                f = in.nextLine();
                i = 0;
                while(f.equals("1")){
                    System.out.println("������� �������� ������");
                    nameItem1 = in.nextLine();
                    System.out.println("������� ��� ������");
                    code1 = in.nextLine();
                    try{
                        System.out.println("������� ����");
                        price1 = in.nextDouble();
                    }
                    catch(Exception e){
                        price1 = 0;
                        in.nextLine();
                    }
                    try{
                        System.out.println("������� �����������");
                        amount1 = in.nextInt();
                    }
                    catch(Exception e){
                        amount1 = 0;
                    }
                    in.nextLine();
                    item[i] = new Item(code1, nameItem1, price1, amount1);
                    i++;
                    System.out.println("�������� �����(1 - ��, 0 - ���)");
                    f = in.nextLine();
                }
                numberOfItems1 = i;
                store[0][0] = new Store(name1, adress1, numberOfItems1, item);
            }
            else if(f.equals("2")){
                System.out.println("������� �������� ��������");
                name1 = in.nextLine();
                store[0][0] = new Store(name1);
            }
            else{
                store[0][0] = new Store();
            }
        }
        f = "0";
        i = 0;
        max = 1;
        max1[0] = 1;
        while(f.equals("10") == false){
            System.out.println("������� ����� ���������� ��������");
            System.out.println("1 - �������� ���������� � ��������");
            System.out.println("2 - �������� ����� ��� ������");
            System.out.println("3 - �������� ���� ������");
            System.out.println("4 - �������� ����������� ������");
            System.out.println("5 - �������� �������");
            System.out.println("6 - �������� ��� ��������");
            System.out.println("7 - ������� �������");
            System.out.println("8 - �������� ����������� �������");
            System.out.println("9 - �������� ����������� ���� ��� ������� � ��������");
            System.out.println("10 - �����");
            f = in.nextLine();
            if(f.equals("1")){
                System.out.println("���� ��������� " + (i + 1));
                for (n = 0; n < max1[i]; n++)
                {
                    System.out.println("������� " + (n + 1));
                    store[i][n].display();
                }
            }
            else if(f.equals("2")){
                System.out.println("������� ����� ��������");
                n = in.nextInt();
                in.nextLine();
                store[i][n-1].add();
            }
            else if(f.equals("3")){
                System.out.println("������� ����� ��������");
                n = in.nextInt();
                in.nextLine();
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                System.out.println("������� ����� ����");
                try{
                    price1 = in.nextDouble();
                }
                catch(Exception e){
                    price1 = 0;
                }
                in.nextLine();
                store[i][n-1].priceChange(code1, price1);
            }
            else if(f.equals("4")){
                System.out.println("������� ����� ��������");
                n = in.nextInt();
                in.nextLine();
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                System.out.println("������� �� ������� ���������� ����������� ������(���� ������������ - ������������� �����, ���� ����������� - �������������)");
                try{
                    amount1 = in.nextInt();
                }
                catch(Exception e){
                    amount1 = 0;
                }
                in.nextLine();
                store[i][n-1].amountChange(code1, amount1);
            }
            else if(f.equals("5")){
                System.out.println("����� ���� ��������� (1), ����� ������� � ������ ���� ��������� (2)");
                n = in.nextInt();
                in.nextLine();
                if (n == 1)
                {
                    store[max][0] = new Store();
                    store[max][0].read();
                    i = max;
                    max++;
                    max1[i] = 1;
                }
                else
                {
                    store[i][max1[i]] = new Store();
                    store[i][max1[i]].read();
                    max1[i]++;
                }
            }
            else if(f.equals("6")){
                for (n = 0; n < max; n++)
                {
                    System.out.println("���� ��������� " + (n + 1));
                    for (i1 = 0; i1 < max1[n]; i1++)
                    {
                        System.out.println("������� " + (i1 + 1));
                        store[n][i1].display();
                    }
                }
            }
            else if(f.equals("7")){
                System.out.println("������� ���� ���������");
                n = in.nextInt();
                in.nextLine();
                i = n - 1;
            }
            else if(f.equals("8")){
                store[i][0].getNumber(k);
                System.out.println(k.number);
            }
            else if(f.equals("9")){
                System.out.println("������� �����������");
                numberOfItems1 = in.nextInt();
                Store.maxNumberOfItemsChange(numberOfItems1);
                in.nextLine();
            }
        }    
    }
}
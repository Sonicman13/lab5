import java.util.Scanner;
import java.util.*;

public class lab5 {
    public static void main(String[] args) {
        String encoding = System.getProperty("console.encoding", "cp866"), name1, adress1, nameItem1, code1, f, publisher;
        String[] platforms = new String[10], components = new String[10], plusPlatforms = new String[10];
        Scanner in = new Scanner(System.in, encoding);
        Store[] store = new Store[10];
        Item[] item1 = new Item[10];
        Game[] game1 = new Game[10];
        Platform[] platform1 = new Platform[10];
        Number k = new Number();
        int numberOfItems1, amount1, i, max, n, d, numberOfGames1, numberOfPlatforms1;
        int[] release = new int[3];
        double price1;
        System.out.println("������ ������ ����� read ��� init(1 - read, 2 - init)");
        f = in.nextLine();
        if(f.equals("1")){
            store[0] = new Store();
            store[0].read();
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
                    item1[i] = new Item(code1, nameItem1, price1, amount1);
                    i++;
                    System.out.println("�������� �����(1 - ��, 0 - ���)");
                    f = in.nextLine();
                }
                numberOfItems1 = i;
                System.out.println("�������� ����(1 - ��, 0 - ���)");
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
                    System.out.println("������� ���� ������(����, �����(�����), ����� ���(4 �����), �������� �� �������� Enter)");
                    release[0] = in.nextInt();
                    release[1] = in.nextInt();
                    release[2] = in.nextInt();
                    in.nextLine();
                    System.out.println("������� ��������� �� ������� �������� ����( ����� ��������� ������� ��������� ������� ������ ������)");
                    d = -1;
                    do
                    {
                        d++;
                        platforms[d] = in.nextLine();
                    } while (!platforms[d].equals(""));
                    System.out.println("������� ��������");
                    publisher = in.nextLine();
                    in.nextLine();
                    game1[i] = new Game(code1, nameItem1, price1, amount1, release, platforms, publisher);
                    i++;
                    System.out.println("�������� ����(1 - ��, 0 - ���)");
                    f = in.nextLine();
                }
                numberOfGames1 = i;
                System.out.println("�������� �������(1 - ��, 0 - ���)");
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
                    System.out.println("������� ������������( ����� ��������� ������� ������������ ������� ������ ������)");
                    d = -1;
                    do
                    {
                        d++;
                        components[d] = in.nextLine();
                    } while (!components[d].equals(""));
                    System.out.println("������� ��������� ��������� �� �������� �������������( ����� ��������� ������� ��������� ������� ������ ������)");
                    d = -1;
                    do
                    {
                        d++;
                        plusPlatforms[d] = in.nextLine();
                    } while (!plusPlatforms[d].equals(""));
                    System.out.println("������� ��������");
                    publisher = in.nextLine();
                    in.nextLine();
                    platform1[i] = new Platform(code1, nameItem1, price1, amount1, components, plusPlatforms, publisher);
                    i++;
                    System.out.println("�������� �������(1 - ��, 0 - ���)");
                    f = in.nextLine();
                }
                numberOfPlatforms1 = i;
                store[0] = new Store(name1, adress1, numberOfItems1, item1, numberOfGames1, game1, numberOfPlatforms1, platform1);
            }
            else if(f.equals("2")){
                System.out.println("������� �������� ��������");
                name1 = in.nextLine();
                store[0] = new Store(name1);
            }
            else{
                store[0] = new Store();
            }
        }
        f = "0";
        i = 0;
        max = 1;
        while(f.equals("10") == false){
            System.out.println("������� ����� ���������� ��������");
            System.out.println("1 - �������� ���������� � ��������");
            System.out.println("2 - �������� ����� ��� ������");
            System.out.println("3 - �������� ���� ������");
            System.out.println("4 - �������� ����������� ������");
            System.out.println("5 - �������� �������");
            System.out.println("6 - �������� ��� ��������");
            System.out.println("7 - ������� �������");
            System.out.println("8 - �������� ������������� � ������� ��� ��������� �� ������� �������� ����");
            System.out.println("9 - ������������");
            System.out.println("10 - �����");
            f = in.nextLine();
            if(f.equals("1")){
                store[i].display();
            }
            else if(f.equals("2")){
                store[i].add();
            }
            else if(f.equals("3")){
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
                store[i].priceChange(code1, price1);
            }
            else if(f.equals("4")){
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
                store[i].amountChange(code1, amount1);
            }
            else if(f.equals("5")){
                store[max] = new Store();
                store[max].read();
                i=max;
                max++;
            }
            else if(f.equals("6")){
                for(n = 0;n < max; n++){
                    store[n].displayName();
                }
            }
            else if(f.equals("7")){
                System.out.println("������� �������� ��������");
                name1 = in.nextLine();
                for(n = 0;n < max;n++){
                    if(store[n].storecmp(name1)){
                        i = n;
                        n = max;
                    }
                }
            }
            else if(f.equals("8")){
                System.out.println("������� ��� ������");
                code1 = in.nextLine();
                store[i].add(code1);
            }
            else if(f.equals("9")){
                release[0] = release[1] = release[2] = 1;
                platforms[0] = "aaa";
                game1[0] = new Game("game", "game", 1, 1, release, platforms, "game");
                components[0] = "bbb";
                platforms[0] = "zzz";
                platform1[0] = new Platform("platform", "platform", 2, 2, components, platforms, "platform");
                game1[1] = (Game)game1[0].clone();
                game1[1].setAmount(2);
                game1[0].display();
                platform1[1] = platform1[0];
                platform1[1].setAmount(3);
                platform1[0].display();
            }
        }    
    }
}
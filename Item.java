import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

interface Add
{
    void add();
}

public class Item 
implements Comparable<Item>
{
    protected String name;
    protected String code;
    protected double price;
    protected int amount;
    void read() {
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner in = new Scanner(System.in, encoding);
        System.out.println("������� �������� ������");
        name = in.nextLine();
        System.out.println("������� ��� ������");
        code = in.nextLine();
        try{
            System.out.println("������� ����");
            price = in.nextDouble();
        }
        catch(Exception e){
            price = 0;
            in.nextLine();
        }
        try{
            System.out.println("������� �����������");
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
    public static final Comparator<Item> compareItem = new Comparator<Item>(){
        @Override
        public int compare(Item x, Item y){
            double k;
            k = x.price - y.price;
            if(k > 0){
                System.out.println("-");
                return -1;
            }
            else{
                System.out.println("+");
                return 1;
            }
        }
    };
    public int compareTo(Item x){
        double k;
        k = this.price - x.price;
        if(k > 0){
            System.out.println("-");
            return -1;
        }
        else{
            System.out.println("+");
            return 1;
        }
    }
}



class Game extends Item
implements Add, Cloneable
    {
        int[] release = new int[3];
        String[] platforms = new String[10];
        String publisher;
        Game()
        {
            name = "-";
            code = "-";
            price = 0;
            amount = 0;
            release[0] = release[1] = release[2] = -1;
            platforms[0] = "-";
            publisher = "-";
        }
        Game(String code, String name, double price, int amount, int[] release1, String[] platforms1, String publisher1)
        {
            super(code, name, price, amount);
            int i;
            for (i = 0; i < 3; i++)
            {
                release[i] = release1[i];
            }
            for (i = 0; i < platforms1.length; i++)
            {
                platforms[i] = platforms1[i];
            }
            publisher = publisher1;
        }
        void read(int d)
        {
            String encoding = System.getProperty("console.encoding", "cp866");
            Scanner in = new Scanner(System.in, encoding);
            super.read();
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
        }
        public void display()
        {        
            System.out.println(ToString());
        }
        public String ToString()
        {
            int d;
            String s;
            s = "��� ������: " + code + "\n";
            s += "�������� ������: " + name + "\n";
            s += "����: " + price + "\n";
            s += "�����������: " + amount + "\n";
            s += "���� ������: " + release[0] + "." + release[1] + "." + release[2] + "\n";
            s += "���������: ";
            for (d = 0; d < platforms.length; d++)
            {
                s += platforms[d] + ", ";
            }
            s += "\n" + "��������: " + publisher;
            return s;
        }
        public void add()
        {
            String encoding = System.getProperty("console.encoding", "cp866");
            Scanner in = new Scanner(System.in, encoding);
            int i;
            i = 0;
            while (!platforms[i].equals(""))
            {
                i++;
            }
            System.out.println("������� ��������� �� ������� �������� ����");
            platforms[i] = in.nextLine();
        }
        public Object clone()
        {
            try{
                return (Game)super.clone();
            }
            catch(CloneNotSupportedException e){
                return this;
            }
        }
    }



class Platform extends Item
implements Add
    {
        String[] components = new String[10];
        String[] plusPlatforms = new String[10];
        String publisher;
        public Platform()
        {
            name = "-";
            code = "-";
            price = 0;
            amount = 0;
            components[0] = "-";
            plusPlatforms[0] = "-";
            publisher = "-";
        }
        public Platform(String code, String name, double price, int amount, String[] components1, String[] platforms1, String publisher1)
        {
            super(code, name, price, amount);
            int i;
            for (i = 0; i < components1.length; i++)
            {
                components[i] = components1[i];
            }
            for (i = 0; i < platforms1.length; i++)
            {
                plusPlatforms[i] = platforms1[i];
            }
            publisher = publisher1;
        }
        public void read(int d)
        {
            String encoding = System.getProperty("console.encoding", "cp866");
            Scanner in = new Scanner(System.in, encoding);
            super.read();
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
        }
        public void display()
        {
            System.out.println(ToString());
        }
        public String ToString()
        {
            int d;
            String s;
            s = "��� ������: " + code + "\n";
            s += "�������� ������: " + name + "\n";
            s += "����: " + price + "\n";
            s += "�����������: " + amount + "\n";
            s += "������������: ";
            for (d = 0; d < components.length; d++)
            {
                s += components[d] + ", ";
            }
            s += "\n" + "��������� ��������� �� �������� �������������: ";
            for (d = 0; d < plusPlatforms.length; d++)
            {
                s += plusPlatforms[d] + ", ";
            }
            s += "\n" + "��������: " + publisher;
            return s;
        }
        public void add()
        {
            String encoding = System.getProperty("console.encoding", "cp866");
            Scanner in = new Scanner(System.in, encoding);
            int i;
            i = 0;
            while (!components[i].equals(""))
            {
                i++;
            }
            System.out.println("������� �������������");
            components[i] = in.nextLine();
        }
    }




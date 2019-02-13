package Ex_1;

import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class Book {
    String name, incorparate, encrypt, author, year;
    Scanner input = new Scanner(System.in);
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //КОНСТРУКТОР
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    boolean buy = false;
    public Book(String name, String incorparate, String year, String encrypt, String author){
        this.name = name;
        this.incorparate = incorparate;
        this.year = year;
        this.encrypt = encrypt;
        this.author = author;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //ПОКУПКА
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void buy() {
        if (!buy) {
            System.out.print("\nКнига куплена");
            buy = true;
        } else {
            System.out.print("Книга уже куплена");
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //ПРОДАЖА
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void sell(){
        if(buy) {
            System.out.print("\nКнига продана");
            buy = false;
        }else{
            System.out.print("У вас нет этой книги");
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //ПРОВЕРКА КУПЛЕНО ИЛИ ПРОДАНО
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void checkBuyOrSell(){
        if (buy){
            System.out.print("\nКнига у вас");
        }else{
            System.out.print("\nУ вас нет этой книги");
        }
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //ВЫВОД НУЖНОЙ ПОЛЬЗОВАТЕЛЮ ИНФОРМАЦИИ
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void getSomeData(){
        try {
            System.out.print("\nЧто вы хотите получить?");
            System.out.print("\n1.Название книги\n2.Издатель\n3.Год выпуска\n4.Шифр\n5.Автор");
            int data = input.nextInt();
            switch (data) {
                case 1:
                    getName();
                    break;
                case 2:
                    getIncorparate();
                    break;
                case 3:
                    getYear();
                    break;
                case 4:
                    getEncrypt();
                    break;
                case 5:
                    getAuthor();
                    break;
                default:
                    System.out.print("\nВы ввели данные неверно.");
                    getSomeData();
            }

        }catch(InputMismatchException e){
            System.out.print("\nВы ввели данные неверно.");
            getSomeData();
        }
        }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК ВЫВОДА ИНФОРМАЦИИ
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        private void getName(){ System.out.print("Название книги: " + name);}
        private void getIncorparate(){
            System.out.print("Издатель: " + incorparate);
        }
        private void getYear(){System.out.print("Год издания: " + year); }
        private void getEncrypt(){
            System.out.print("Шифр: " + encrypt);
        }
        private void getAuthor(){ System.out.print("Автор: " + author); }
}

package Ex_1;

public abstract class Book {
    String name, incorparate, encrypt, author;
    int year;
    boolean buy = false;
    public Book(String name, String incorparate, int year, String encrypt, String author){
        this.name = name;
        this.incorparate = incorparate;
        this.year = year;
        this.encrypt = encrypt;
        this.author = author;
    }

    public void buy(){
        System.out.print("\nКнига куплена");
        buy = true;
    }

    public void sell(){
        System.out.print("\nКнига продана");
        buy = false;
    }

    public void checkBuyOrSell(){
        if (buy){
            System.out.print("\nКнига у вас");
        }else{
            System.out.print("\nУ вас нет этой книги");
        }
    }
}

package Ex_1;

import java.util.Random;
import java.util.Scanner;

public class Enciklopedia extends Book{
    Random rand = new Random();
    public Enciklopedia(String name, String incorparate, int year, String encrypt, String author){
        super(name, incorparate, year, encrypt,author);
    }

    public void getData(String data){//вывод рандомной статьи по одной из тем
        Scanner input = new Scanner(System.in);
        System.out.print("1.Животное 2.Растение 3.Книга\nВведите название одной из тем: ");
        String in = input.next();


        switch (data.toUpperCase()){
            case "ЖИВОТНОЕ":
                getAnimal();
                break;
            case "РАСТЕНИЕ":
                getPlant();
                break;
            case "КНИГА":
                getBook();
                break;
        }
    }

    private void getAnimal(){// выводит рандомную статью из энциклопедии по теме животные

    }
    private void getPlant(){// по теме растания

    }
    private void getBook(){// по теме книга

    }
}

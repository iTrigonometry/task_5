package Ex_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Enciklopedia extends Book{
    Random rand = new Random();
    public Enciklopedia(String name, String incorparate, String year, String encrypt, String author){
        super(name, incorparate, year, encrypt,author);
    }

    public void getData(){//вывод рандомной статьи по одной из тем
        Scanner input = new Scanner(System.in);
        System.out.print("1.Животное 2.Растение 3.Книга\nВведите название одной из тем: ");
        String in = input.next();


        switch (in.toUpperCase()){
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

    private void getAnimal() {// выводит рандомную статью из энциклопедии по теме животные
        try {
            int random = rand.nextInt(2);
            String path = "file/animals.txt";
            String content = Files.readAllLines(Paths.get(path)).get(random);
            System.out.print(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void getPlant(){// по теме растания
        try {
            int random = rand.nextInt(2);
            String path = "file/plants.txt";
            String content = Files.readAllLines(Paths.get(path)).get(random);
            System.out.print(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void getBook(){// по теме книга
        try {
            int random = rand.nextInt(2);
            String path = "file/books.txt";
            String content = Files.readAllLines(Paths.get(path)).get(random);
            System.out.print(content);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

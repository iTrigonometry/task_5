package Ex_1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

//класс для ээнциклопедии
public class Enciklopedia extends Book {
    Random rand = new Random();

    public Enciklopedia(String name, String incorparate, String year, String encrypt, String author) {//конструктор класса
        super(name, incorparate, year, encrypt, author);

    }

    public void getData() {//вывод рандомной статьи по одной из тем
        Scanner input = new Scanner(System.in);
        System.out.print("1.Животное 2.Растение 3.Книга\nВведите название одной из тем: ");
        String in = input.next();

        switch (in.toUpperCase()) {
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
            int random = rand.nextInt(3);//получаем рандомное число, чтобы выбрать какую строчку выводить
            String path = "file/animals.txt";//местоположение файла
            System.out.println();
            String content = Files.readAllLines(Paths.get(path)).get(random);//новый модный молодежный способ читать строки, в данном случае читается конкретная строка
            System.out.print(content);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getPlant() {// по теме растания
        try {
            int random = rand.nextInt(3);
            String path = "file/plants.txt";
            System.out.println();
            String content = Files.readAllLines(Paths.get(path)).get(random);
            System.out.print(content);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getBook() {// по теме книга
        try {
            int random = rand.nextInt(3);
            String path = "file/books.txt";
            System.out.println();
            String content = Files.readAllLines(Paths.get(path)).get(random);
            System.out.print(content);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

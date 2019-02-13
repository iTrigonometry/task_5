import Ex_1.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК ПРОСТО БЛОК
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) {
        System.out.print("Вы заходите в библиотеку и вас встречает бабушка лет восьмидесяти и предлагает вам две книги.");
        fake_main();
    }

    public static void fake_main() {
        System.out.print("\nПервая книга это справочник а вторая энциклопедия.");
        System.out.print("\nВведите номер выборанной книги: ");
        int action = input(true);
        actionToStart(action);
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК ДЕЙСВИЙ С КНИГАМИ
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void actionToStart(int action) {
        System.out.print("Выбор сделан. Назад дороги нет.");
        if (action == 1) {
            System.out.print("\nВы хотите посмотреть последний справочник(1) или посмотреть на новый(2)? \nВведите цифру:");
            Spravochnik spr = create_Spravochnik(input(true));
            actionForSpravochnik(spr);
        } else {
            System.out.print("\nВы хотите посмотреть последнюю энциклопедию(1) или посмотреть на новую(2)? \nВведите цифру:");
            Enciklopedia enc = create_Enciklopedia(input(true));
            actionForEnciklopedia(enc);

        }
    }

    public static void actionForSpravochnik(Spravochnik spr) {
        System.out.print("\nДействия доступные со Справочником. \n1.Сжечь\n2.Реставрировать\n3.Узнать " +
                "сожжена ли книга\n4.Узнать можно ли отреставрировать книгу.\n5.Купить книгу\n6.Продать книгу." +
                "\n7.Узнать информацию о книге.\n8.Вернуть книгу\n9.Уйти из библиотеки");
        System.out.print("\nВведите действие: ");
        int action = input(false);
        switch (action) {
            case 1:
                spr.burnTheBook();
                actionForSpravochnik(spr);
                break;
            case 2:
                spr.restavrationBook();
                actionForSpravochnik(spr);
                break;
            case 3:
                spr.checkBurned();
                actionForSpravochnik(spr);
                break;
            case 4:
                spr.checkRestavration();
                actionForSpravochnik(spr);
                break;
            case 5:
                spr.buy();
                actionForSpravochnik(spr);
                break;
            case 6:
                spr.sell();
                actionForSpravochnik(spr);
                break;
            case 7:
                spr.getSomeData();
                actionForSpravochnik(spr);
                break;
            case 8:
                System.out.print("\nВы вернули книгу.");
                fake_main();
            case 9:
                System.exit(0);
            default:
                System.out.print("\nВы ввели данные неверно.");
                actionForSpravochnik(spr);
        }

    }


    public static void actionForEnciklopedia(Enciklopedia enc) {
        System.out.print("\nДействия доступные с Энциклопедией. \n1.Открыть случайную страницу по теме\n2.Купить книгу\n3.Продать книгу." +
                "\n4.Узнать информацию о книге.\n5.Вернуть книгу и взять другую.\n6.Уйти из библиотеки");
        System.out.print("\nВведите действие: ");
        int action = input(false);
        switch (action) {
            case 1:
                enc.getData();
                actionForEnciklopedia(enc);
                break;
            case 2:
                enc.buy();
                actionForEnciklopedia(enc);
                break;
            case 3:
                enc.sell();
                actionForEnciklopedia(enc);
                break;
            case 4:
                enc.getSomeData();
                actionForEnciklopedia(enc);
                break;
            case 5:
                System.out.print("\nВы вернули книгу.");
                fake_main();
            case 6:
                System.exit(0);
            default:
                System.out.print("\nВы ввели данные неверно.");
                actionForEnciklopedia(enc);
        }


    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК СОЗДАНИЯ ВЫБРАННОЙ КНИГИ
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static Spravochnik create_Spravochnik(int action) {
        String path = "file/spr.txt";
        Spravochnik spr;
            if (action == 2) {
                Random rand = new Random();

                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите имя книги:");
                String name = input.nextLine();
                rewriter(0, name, path);
                System.out.print("\nВведите издательство: ");
                String incorporation = input.nextLine();
                rewriter(1, incorporation, path);
                System.out.print("\nВедите год издательства: ");
                String year = input.nextLine();
                rewriter(2, year, path);
                System.out.print("\nВведите автора: ");
                String author = input.nextLine();
                rewriter(3, author, path);
                String encrypt = "Русский";
                spr = new Spravochnik(name, incorporation, year, encrypt, author, rand.nextInt(2080));
                return spr;
            } else {

                Random rand = new Random();
                spr = new Spravochnik(reader(0,path), reader(1, path), reader(2, path),"Русский", reader(3, path), rand.nextInt(3000));
                return spr;
            }

        //return spr = new Spravochnik("name", "incorparation", "year", "Русский", "author", 2080);
    }

        public static Enciklopedia create_Enciklopedia (int action){
            String path = "file/enc.txt";
        if (action == 2) {
                Scanner input = new Scanner(System.in);
                System.out.print("\nВведите имя книги:");
                String name = input.nextLine();
                rewriter(0, name, path);
                System.out.print("\nВведите издательство: ");
                String incorporation = input.nextLine();
                rewriter(1, incorporation, path);
                System.out.print("\nВедите год издательства: ");
                String year = input.nextLine();
                rewriter(2, year, path);
                System.out.print("\nВведите автора: ");
                String author = input.nextLine();
                rewriter(3, author, path);
                String encrypt = "Русский";
                Enciklopedia enc = new Enciklopedia(name, incorporation, year, encrypt, author);
                return enc;
            } else{
                    Enciklopedia enc = new Enciklopedia(reader(0, path),reader(1, path) , reader(2,path), "Русский",reader(3,path));
                    return enc;

//                return new Enciklopedia("123", "123", "123", "123", "123");
            }
        }


        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //БЛОК ВВОДА ДАННЫХ
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        public static int input (boolean flag)
        {//метод для ввода данных. если нужно ввести выбор книги то работает первая часть программы, если просто ввести то вторая
            Scanner input = new Scanner(System.in);
            if (flag) {//первая часть программы
                try {
                    int action = input.nextInt();
                    if (action != 1 && action != 2) {
                        System.out.print("\nВы ввели неверное значение. Введите заново: ");
                        input(true);
                    }
                    return action;
                } catch (InputMismatchException e) {
                    System.out.print("\nВы ввели неверное значение. Введите заново: ");
                    input(true);
                }
            } else {//вторая часть программы
                try {
                    int action = input.nextInt();
                    return action;
                } catch (InputMismatchException e) {
                    System.out.print("\nВы ввели неверное значение. Введите заново: ");
                    input(false);
                }
            }
            return 0;//без этой строчки не работает, потому что нет 100% возвращения
        }

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //БЛОК ЗАПИСИ ДАННЫХ В ФАЙЛ
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        public static void rewriter (int parametr, String whatIWant, String paths){
            try {
                Path path =  Paths.get(paths);
                Charset charset = StandardCharsets.UTF_8;
                String content = new String(Files.readAllBytes(path), charset);
                String temp = Files.readAllLines(path).get(parametr);
                content = content.replaceAll(temp, whatIWant);
                Files.write(path, content.getBytes(charset));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static String reader(int parametr, String path) {
            try {
                String content = Files.readAllLines(Paths.get(path)).get(parametr);
                return content;
            }catch (IOException e){
                e.printStackTrace();
            }
            return "";
        }

}

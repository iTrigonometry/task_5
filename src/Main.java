import Ex_1.*;
//TODO переписать метод input, нужна универсальность для всех вводов
import java.lang.management.GarbageCollectorMXBean;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/*
план действий такой
 нужно создать метод программы
для примера человек заходит в библиотеку и ему предлагают либо купить книгу или взять попользоваться
если человек покупает книгу, то он имеет полное право на то чтобы делать с книгой что захочет
если взял попользоваться то его функционал ограничен тем что он может что то прочитать из нее(открыв рандомную страницу) (переписать вывод для всего этого)
в конце концов он просто возвращает книгу, продает книгу или оставляет себе.
В самом конце человека нужно спросить хочет ли он посмотреть еще книги  и если хочет то начать все сначала если не хочет то завершить программу
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Вы заходите в библиотеку и вас встречает бабушка лет восьмидесяти и предлагает вам две книги.");
        fake_main();
    }

    public static void actionToStart(int action) {
        System.out.print("Выбор сделан. Назад дороги нет.");
        if (action == 1) {
            System.out.print("\nВы выбрали справочник. Ох какое совпадение. Вы можете сами заполнить обложку.");
            Spravochnik spr = create_Spravochnik();
            actionForSpravochnik(spr);
        } else {
            System.out.print("\nВы выбрали Энциклопедию. Ох какое совпадение. Вы можете сами заполнить обложку.");
            Enciklopedia enc = create_Enciklopedia();
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
            case 9:System.exit(0);
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
            case 6:System.exit(0);
            default:
                System.out.print("\nВы ввели данные неверно.");
                actionForEnciklopedia(enc);
        }


    }

    public static int input(boolean flag) {
        Scanner input = new Scanner(System.in);
        if (flag) {
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
        } else {
            try {
                int action = input.nextInt();
                    return action;
                } catch (InputMismatchException e) {
                System.out.print("\nВы ввели неверное значение. Введите заново: ");
                input(false);
            }
        }
        return 0;
    }



        public static void fake_main () {
            System.out.print("\nПервая книга это справочник а вторая энциклопедия.");
            System.out.print("\nВведите номер выборанной книги: ");
            int action = input(true);
            actionToStart(action);
        }

        public static Spravochnik create_Spravochnik(){
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            System.out.print("\nВведите имя книги:");
            String name = input.nextLine();
            System.out.print("\nВведите издательство: ");
            String incorporation = input.nextLine();
            System.out.print("Ведите год издательства: ");
            String year = input.nextLine();
            System.out.print("Введите автора: ");
            String author = input.nextLine();
            String encrypt = "Русский";
            Spravochnik spr= new Spravochnik(name, incorporation, year, encrypt, author, 123);
            return spr;
        }
        public static Enciklopedia create_Enciklopedia(){
            Scanner input = new Scanner(System.in);
            System.out.print("\nВведите имя книги:");
            String name = input.nextLine();
            System.out.print("\nВведите издательство: ");
            String incorporation = input.nextLine();
            System.out.print("Ведите год издательства: ");
            String year = input.nextLine();
            System.out.print("Введите автора: ");
            String author = input.nextLine();
            String encrypt = "Русский";
            Enciklopedia enc= new Enciklopedia(name, incorporation, year, encrypt, author);
            return enc;
        }
    }

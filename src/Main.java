import Ex_1.*;

import java.util.InputMismatchException;
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
            System.out.print("\nВы выбрали справочник. Ох какое совпадение. Вы можете сами заполнить обложку.");
            Enciklopedia enc = cre();
            actionForEnciklopedia();
        }
    }

    public static void actionForSpravochnik(Spravochnik spr) {


    }


    public static void actionForEnciklopedia(Enciklopedia enc) {


    }

    public static int input() {
        Scanner input = new Scanner(System.in);
        try {
            int action = input.nextInt();
            input.close();
            if (action != 1 || action != 2) {
                System.out.print("\nВы ввели неверное значение. Введите заново: ");
                input();
            }
            return action;
        } catch (InputMismatchException e) {
            System.out.print("\nВы ввели неверное значение. Введите заново: ");
            input();
        }
            return 0;
    }
        public static void fake_main () {
            System.out.print("\nПервая книга это справочник а вторая энциклопедия.");
            System.out.print("\nВыберай лошара");
            System.out.print("\nВведите номер выборанной книги.");
            int action = input();
            actionToStart(action);
        }

        public static Spravochnik create_Spravochnik(){
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            String incorporation = input.nextLine();
            String year = input.nextLine();
            String author = input.nextLine();
            String encrypt = "Русский";
            input.close();
            Spravochnik spr= new Spravochnik(name, incorporation, year, encrypt, author, 123);
            return spr;
        }
    }

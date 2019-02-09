package Ex_1;
//123
//TODO Сделать рандомное определение durability
//TODO Изменить значения для возможности или не возможности восстоновления книги
public class Spravochnik extends Book {
    boolean burned = false;//изначально книга существуует
    int durability;//прочность книги определяет можно ли восстоновить книгу
    boolean durabilityb;//если книгу можно будет восстоновить то будет тру

    public Spravochnik(String name, String incorparate, String year, String encrypt, String author, int durability) {
        super(name, incorparate, year, encrypt, author);
        this.durability = durability;//дополнительный параметр для конструктора котоырый дополняет то что есть в суперклассе
        setRestavration();
    }

    private void setRestavration() {//узнаем можно ли взять да восстановить книгу
        if (durability >= 1050) {
            durabilityb = true;
        } else {
            durabilityb = false;
        }
    }

    public void burnTheBook() {//сжечь книгу
        if (buy) {
            burned = true;
            System.out.print("\nКнига сожжена");
        } else
            System.out.print("\nУ вас даже нет этой книги");
    }

    public void restavrationBook() {//восстановление книги
        if (durabilityb) {
            burned = false;
            System.out.print("\nКнига отреставрированна");
        } else {
            System.out.print("\nКнига не подлежит восстановлению");
        }
    }

    public void checkBurned() {//даем информацию о книге
        if (buy) {
            if (burned && durabilityb) {
                System.out.print("\nКнига была сожжена, но подлежит востановлению");
            } else if (burned && !durabilityb) {

                System.out.print("\nКнига была сожжена и не подлежит востановлению");
            } else {
                System.out.print("\nКнига в целости и сохранности");
            }
        } else {
            System.out.print("У вас нет этой книги");
        }
    }

    public void checkRestavration() {//выводим информацию о том можно ли реставрировать книгу
        if (buy) {
            if (durabilityb) {
                System.out.print("\nКнига подлежит востановлению");
            } else {
                System.out.print("\nКнига не подлежит востановлению");
            }
        }else{
            System.out.print("У вас нет этой книги");
        }
    }
}


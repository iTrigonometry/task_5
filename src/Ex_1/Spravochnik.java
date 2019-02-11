package Ex_1;

public class Spravochnik extends Book {
    private boolean burned = false;//изначально книга существуует
    private int durability;//прочность книги определяет можно ли восстоновить книгу
    private boolean durabilityb;//если книгу можно будет восстоновить то будет тру


    //КОНСТРУКТОР
    public Spravochnik(String name, String incorparate, String year, String encrypt, String author, int durability) {
        super(name, incorparate, year, encrypt, author);
        this.durability = durability;//дополнительный параметр для конструктора котоырый дополняет то что есть в суперклассе
        setRestavration();
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК ДЛЯ РЕСТАВРАЦИИ
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void restavrationBook() {//восстановление книги
        if (durabilityb) {
            burned = false;
            System.out.print("\nКнига отреставрированна");
        } else {
            System.out.print("\nКнига не подлежит восстановлению");
        }
    }

    private void setRestavration() {//узнаем можно ли взять да восстановить книгу
        if (durability >= 1050) {
            durabilityb = true;
        } else {
            durabilityb = false;
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

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //БЛОК ДЛЯ СЖИГАНИЯ КНИГИ
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void burnTheBook() {//сжечь книгу
        if (buy) {
            burned = true;
            System.out.print("\nКнига сожжена");
        } else
            System.out.print("\nУ вас даже нет этой книги");
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
}


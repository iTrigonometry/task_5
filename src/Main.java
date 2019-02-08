import Ex_1.*;
public class Main {
    public static void main(String[] args){
        //вот так нельзя написать так как класс абстрактный и изначально
        // предполагает что он не доработан
        //Book book = new Book();
        //создаем экземпляр класса
        Spravochnik spr = new Spravochnik("Справочник бытовой техники", "Сын собаки", 2018, "Русский", "Ya", 1080);
        //воспользуемся методами которые есть в классе справочник
        spr.burnTheBook();
        spr.checkRestavration();
        spr.checkBurned();
        spr.restavrationBook();
        //для примера можно воспользоваться классами из нашего суперкласса
        spr.checkBuyOrSell();
    }
}

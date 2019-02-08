package Ex_1;
//123
public class Spravochnik extends Book{
    boolean burned = false;
    int durability = 1050;
    boolean durabilityb = false;
    public Spravochnik(String name,String incorparate, int year, String encrypt, String author , int durability){
        super(name, incorparate, year, encrypt, author);
        this.durability = durability;
        setRestavration();
    }
        private void setRestavration(){
        if (durability >= 1050 ){
            durabilityb = true;
        }else{
            durabilityb = false;
        }
    }

    public void burnTheBook(){
        burned = true;
        System.out.print("\nКнига сожжена");
    }

    public void restavrationBook(){
        burned = false;
        System.out.print("\nКнига отреставрированна");
    }

    public void checkBurned(){
        if (burned && durabilityb){
            System.out.print("\nКнига была сожжена, но подлежит востановлению");
        }else if(burned && !durabilityb){

            System.out.print("\nКнига была сожжена и не подлежит востановлению");
        }
        else{
            System.out.print("\nКнига в целости и сохранности");
        }
    }

    public void checkRestavration(){
        if (durability > 1050){
            System.out.print("\nКнига подлежит востановлению");
        }else{
            System.out.print("\nКнига не подлежит востановлению");
        }
    }
}

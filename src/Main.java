public class Main {
    public static void main(String[] args) {
        Fighter f1= new Fighter("Jin Kazama",80,20,100);
        Fighter f2= new Fighter("Nina Williams",70,15,100);

        Match match= new Match(f1,f2,70,85);
        match.run();
    }
}
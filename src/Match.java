import java.util.Random;

public class Match {
    Fighter fighter1;
    Fighter fighter2;
    int minWeight, maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    boolean isAvailable() {
        return (fighter1.weight >= minWeight && fighter1.weight <= maxWeight && fighter2.weight >= minWeight && fighter2.weight <= maxWeight);
        //Dövüşçülerin siklet ağırlığını uyup uymadığını kontrol eder
    }


    int start() {//Dövüşe kimin başlayacağını %50 olasılıkla belirler
        Random random = new Random();
        int chance = random.nextInt(2);
        if (chance == 0) {
            System.out.println("Dövüşe 1.yarışmacı başlayacak \n");
            return 1;
        } else {
            System.out.println("Dövüşe 2.yarışmacı başlayacak \n");
            return 2;
        }
    }

    void run() {
        int first=start();
        if (isAvailable()) {
            while (fighter1.health > 0 && fighter2.health > 0) {
                //ilk oyuncu seçildikten sonra birbirlerine sırayla vurmaya başlarlar
                if (first == 1) {
                    fighter2.health = fighter1.hit(fighter2);
                    isWin();
                    fighter1.health = fighter2.hit(fighter1);
                    isWin();
                }
                if(first==2){
                    fighter1.health=fighter2.hit(fighter1);
                    isWin();
                    fighter2.health= fighter1.hit(fighter2);
                    isWin();
                }
                System.out.println(fighter1.name+" canı: "+fighter1.health);
                System.out.println(fighter2.name+" canı: "+fighter2.health);
                System.out.println(" ");
            }
        } else {
            System.out.println("Dövüşçülerin sikletleri uymuyor!");
        }
    }
    void isWin() {
        if (fighter1.health == 0) {
            System.out.println("Dövüşü 2.yarışmacı kazandı");
            System.exit(0);
        }
        if (fighter2.health == 0) {
            System.out.println("Dövüşü 1.yarışmacı kazandı");
            System.exit(0);
        }
    }

}
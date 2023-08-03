public class Fighter {
    String name;
    int weight;//Dövüşçünün ağırlığı
    int damage;//Dövüşçünün verdiği hasar
    int health;//Dövüşçünün canı

    Fighter(String name,int weight,int damage,int health){
        this.name=name;
        this.weight=weight;
        this.health=health;
        this.damage=damage;
    }
    int hit(Fighter opponent){
        if(opponent.health<0){//Can değeri -'ye düşmesin diye 0dan küçük ise default olarak 0
            return 0;
        }
        System.out.println(this.name+" => "+ opponent.name +" "+ damage+" vurdu");
        return opponent.health-damage; //her vuruşta dövüşçünün sağlığı karşıdakinin vurduğu kadar azalır
    }
}
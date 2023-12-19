package org.example;

public class Hero {
    String name;

    float hp;

    float armor;

    int moveSpeed;

    void keng() {
        System.out.println("坑队友");

    }
    float getArmor() {
        return armor;
    }

    void addSpeed(int speed) {
        moveSpeed += speed;
    }

    // 超神
    void legendary() {
        System.out.println("超神");
    }

    float getHp() {
        return hp;
    }
    void recover(float blood) {
        hp += blood;
    }

    public static void main(String[] args) {
        Hero garen = new Hero();
        garen.name = "盖伦";
        garen.hp = 500;
        System.out.println(garen.name + " 当前的血量是 " + garen.hp);
        garen.recover(100);
        System.out.println(" 现在的血量是 " + garen.hp);
    }
}

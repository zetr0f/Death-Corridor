package ir.ac.kntu.gamelogic.game;

import ir.ac.kntu.gamelogic.randomGenerator.RandomHelper;

import java.util.Objects;

public class Soldier {
    private int number;
    private int health;
    private Gun gun;
    private Side side;

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Soldier(int health , int number , Side side) {
        this.health = health;
        this.side = side;
        if (RandomHelper.nextBoolean()) {
            gun = new AssaultRifle();
        } else {
            gun = new SniperRifle();
        }
        this.number=number;
    }

    public Soldier(int number , Side side) {
        this(100,number,side);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isHitTarget() {
        return RandomHelper.nextInt(100)  < gun.getCollisionRate();
    }

    public void decreaseHealth(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soldier)) return false;
        Soldier soldier = (Soldier) o;
        return getNumber() == soldier.getNumber() &&
                getHealth() == soldier.getHealth() &&
                Objects.equals(getGun(), soldier.getGun()) &&
                getSide() == soldier.getSide();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getHealth(), getGun(), getSide());
    }

    @Override
    public String toString() {
        return "[S" +number +
                " $health= " + health +
                " @"+ gun.getClass().getSimpleName()+
                " @" + gun.getAmmo()+
                ']'                ;
    }

}
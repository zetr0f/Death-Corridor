package ir.ac.kntu.gamelogic.game;

import ir.ac.kntu.gamelogic.randomGenerator.RandomHelper;

import java.util.Objects;

public class Gun {
    private int collisionRate;
    private int injuryRate;
    private Ammo ammo;

    public Gun() {
        if (RandomHelper.nextBoolean()) {
            ammo = Ammo.CALIBER7;
        } else {
            ammo = Ammo.CALIBER5;
        }
    }

    public int getCollisionRate() {
        return collisionRate;
    }

    public int getInjuryRate() {
        return injuryRate;
    }

    public Ammo getAmmo() {
        return ammo;
    }

    public void setCollisionRate(int collisionRate) {
        this.collisionRate = collisionRate;
    }

    public void setInjuryRate(int injuryRate) {
        this.injuryRate = injuryRate;
    }

    public void setAmmo(Ammo ammo) {
        this.ammo = ammo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gun)) {
            return false;
        }
        Gun gun = (Gun) o;
        return getCollisionRate() == gun.getCollisionRate() &&
                getInjuryRate() == gun.getInjuryRate() &&
                getAmmo() == gun.getAmmo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCollisionRate(), getInjuryRate(), getAmmo());
    }

    @Override
    public String toString() {
        return "Gun{" +
                "collisionRate=" + collisionRate +
                ", injuryRate=" + injuryRate +
                ", ammo=" + ammo +
                '}';
    }
}

package ir.ac.kntu.gamelogic.game;

public class AssaultRifle extends Gun{
    public AssaultRifle() {
        if (getAmmo().equals(Ammo.CALIBER7)) {
            setCollisionRate(50-10);
            setInjuryRate(10+10);
        } else {
            setCollisionRate(50+15);
            setInjuryRate(10);
        }
    }

    @Override
    public String toString() {
        return "AssaultRifle{"
                + "ammo=" + getAmmo()
                + "}";
    }
}
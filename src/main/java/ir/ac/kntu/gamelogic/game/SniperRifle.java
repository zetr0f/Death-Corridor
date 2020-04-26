package ir.ac.kntu.gamelogic.game;

import ir.ac.kntu.gamelogic.randomGenerator.RandomHelper;

import java.util.Objects;

public class SniperRifle extends Gun {
    private boolean isZoom;

    public SniperRifle() {
        isZoom = RandomHelper.nextBoolean();
        if (getAmmo().equals(Ammo.CALIBER7)) {
            setCollisionRate(60-10);
            setInjuryRate(20+10);
        } else {
            setCollisionRate(60+15);
            setInjuryRate(20);
        }
        if (isZoom) {
            setCollisionRate(getCollisionRate()+5+RandomHelper.nextInt(11));
        }
    }

    public boolean isZoom() {
        return isZoom;
    }

    public void setZoom(boolean zoom) {
        isZoom = zoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SniperRifle)) {
            return false;
        }
        if (!super.equals(o)) return false;
        SniperRifle that = (SniperRifle) o;
        return isZoom() == that.isZoom();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isZoom());
    }

    @Override
    public String toString() {
        return "SniperRifle{" +
                "ammo=" + getAmmo() +
                "isZoom=" + isZoom +
                '}';
    }
}

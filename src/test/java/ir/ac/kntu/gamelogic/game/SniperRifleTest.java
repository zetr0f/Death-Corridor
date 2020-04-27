package ir.ac.kntu.gamelogic.game;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SniperRifleTest {
    SniperRifle sniperRifleTest = new SniperRifle();

    @Test
    void getCollisionRate() {
        if (sniperRifleTest.getAmmo().equals(Ammo.CALIBER7)) {
            if (sniperRifleTest.isZoom()) {
                Assert.assertTrue(sniperRifleTest.getCollisionRate() >= 55
                        && sniperRifleTest.getCollisionRate() <=65);
            } else {
                Assert.assertEquals(50, sniperRifleTest.getCollisionRate());
            }
        } else {
            if (sniperRifleTest.isZoom()) {
                Assert.assertTrue(sniperRifleTest.getCollisionRate() >= 80
                        && sniperRifleTest.getCollisionRate() <=90);
            } else {
                Assert.assertEquals(75, sniperRifleTest.getCollisionRate());
            }
        }
    }

    @Test
    void getInjuryRate() {
        if (sniperRifleTest.getAmmo().equals(Ammo.CALIBER7)) {
            Assert.assertEquals(30, sniperRifleTest.getInjuryRate());
        } else {
            Assert.assertEquals(20, sniperRifleTest.getInjuryRate());
        }
    }

    @Test
    void getAmmo() {
        if (sniperRifleTest.getInjuryRate() == 30) {
            Assert.assertEquals(Ammo.CALIBER7, sniperRifleTest.getAmmo());
        } else {
            Assert.assertEquals(Ammo.CALIBER5, sniperRifleTest.getAmmo());
        }
    }
}
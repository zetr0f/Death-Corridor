package ir.ac.kntu.gamelogic.game;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    Soldier attacker = new Soldier(2, Side.DEFENDER);
    Soldier defender = new Soldier(1, Side.ATTACKER);

    @Test
    void getAndSetSide() {
        setSide();
        Assert.assertEquals(Side.ATTACKER, attacker.getSide());
        Assert.assertEquals(Side.DEFENDER, defender.getSide());
    }
    void setSide() {
        attacker.setSide(Side.ATTACKER);
        defender.setSide(Side.DEFENDER);
    }

    @Test
    void getAndSetNumber() {
        setNumber();
        Assert.assertEquals(1,attacker.getNumber());
        Assert.assertEquals(2, defender.getNumber());
    }
    void setNumber() {
        attacker.setNumber(1);
        defender.setNumber(2);
    }

    @Test
    void isAlive() {
        Assert.assertTrue(attacker.getHealth() > 0);
    }

    @Test
    void decreaseHealth() {
        attacker.decreaseHealth(50);
        Assert.assertEquals(50,attacker.getHealth());
    }
}
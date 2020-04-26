package ir.ac.kntu.gamelogic.game;

import ir.ac.kntu.gamelogic.randomGenerator.RandomHelper;

import java.util.ArrayList;
import java.util.Objects;

public class Corridor {
    private int size;
    private ArrayList<Soldier> attackers;
    private ArrayList<Soldier> defenders;

    public Corridor(int size) {
        this.size = size;
        attackers = new ArrayList<>();
        defenders = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            attackers.add(new Soldier(i,Side.ATTACKER));
            defenders.add(new Soldier(i,Side.DEFENDER));
        }
    }

    public void playARound() {
        int attackerIndex = RandomHelper.nextInt(attackers.size());
        int defenderIndex = RandomHelper.nextInt(defenders.size());
        Soldier firstShooter;
        Soldier secondShooter;
        if (RandomHelper.nextBoolean()) {
            firstShooter = attackers.get(attackerIndex);
            secondShooter = defenders.get(defenderIndex);
        } else {
            firstShooter = defenders.get(defenderIndex);
            secondShooter = attackers.get(attackerIndex);
        }
        if (firstShooter.isHitTarget()) {
            secondShooter.decreaseHealth(firstShooter.getGun().getInjuryRate());
        }
        if (secondShooter.isAlive()) {
            firstShooter.decreaseHealth(secondShooter.getGun().getInjuryRate());
            if (!firstShooter.isAlive()) {
                if (firstShooter.getSide().equals(Side.ATTACKER)) {
                    attackers.remove(attackerIndex);
                } else {
                    defenders.remove(defenderIndex);
                }
            }
        } else {
            if (secondShooter.getSide().equals(Side.ATTACKER)) {
                attackers.remove(attackerIndex);
            } else {
                defenders.remove(defenderIndex);
            }
        }
    }

    public boolean isLastRound() {
        return attackers.isEmpty() || defenders.isEmpty();
    }

    public boolean isAttackersWon() {
        return defenders.isEmpty();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<Soldier> getAttackers() {
        return attackers;
    }

    public void setAttackers(ArrayList<Soldier> attackers) {
        this.attackers = attackers;
    }

    public ArrayList<Soldier> getDefenders() {
        return defenders;
    }

    public void setDefenders(ArrayList<Soldier> defenders) {
        this.defenders = defenders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Corridor)) {
            return false;
        }
        Corridor corridor = (Corridor) o;
        return getSize() == corridor.getSize() &&
                Objects.equals(getAttackers(), corridor.getAttackers()) &&
                Objects.equals(getDefenders(), corridor.getDefenders());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getAttackers(), getDefenders());
    }
}

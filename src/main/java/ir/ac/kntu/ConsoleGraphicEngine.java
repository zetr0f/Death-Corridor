package ir.ac.kntu;

import ir.ac.kntu.gamelogic.game.Corridor;

public class ConsoleGraphicEngine {
    private static ScannerSingleton input = ScannerSingleton.getInstance();

    public static void deathCorridor(){
        System.out.println("please enter the number of each side soldiers:");
        int size = Integer.parseInt(input.nextLine());
        System.out.println(size);
        Corridor corridor = new Corridor(size);
        for (int i = 0; ; i++) {
            System.out.println("\n\n\n#############Round "+i+" begin#############");
            System.out.println("attackers:");
            for (int j = 0; j < corridor.getAttackers().size(); j++) {
                System.out.println(corridor.getAttackers().get(j));
            }
            System.out.println("defenders:");
            for (int j = 0; j < corridor.getDefenders().size(); j++) {
                System.out.println(corridor.getDefenders().get(j));
            }
            System.out.println("\nattackers alive=" + corridor.getAttackers().size());
            System.out.println("defenders alive=" + corridor.getDefenders().size());
            System.out.println("#############Round "+i+" end#############");
            if (corridor.isLastRound()) {
                if (corridor.isAttackersWon()) {
                    System.out.println("attackers won!!");
                } else {
                    System.out.println("defenders won!!");
                }
                break;
            }
            corridor.playARound();
            pause();
        }
    }
    private static void pause(){
        System.out.println("press any key to show next round");
        input.nextLine();
    }
}

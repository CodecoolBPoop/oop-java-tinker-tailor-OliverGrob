package com.codecool.tinkertailor;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class TinkerTailor {

    public static List<Integer> playGame(int playerNumber, int syllableSequenceLength) {
        List<Integer> players = new LinkedList<>();

        for (int i = 0; i < playerNumber; i++) {
            players.add(i + 1);
        }

        ListIterator listIterator = players.listIterator();
        List<Integer> outcome = new LinkedList<>();

        while (players.size() > 1) {
            for (int i = 0; i < syllableSequenceLength; i++) {
                if (!listIterator.hasNext()) {
                    listIterator = players.listIterator();
                }

                listIterator.next();

                if (i == syllableSequenceLength - 1) {
                    outcome.add(players.get(listIterator.previousIndex()));
                    listIterator.remove();
                }
            }
        }
        outcome.add(players.get(0));

        return outcome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of players are in: ");
        int playerNumber = scanner.nextInt();
        System.out.println("Enter the length of the syllable sequence: ");
        int syllableSequenceLength = scanner.nextInt();

        System.out.println(playGame(playerNumber, syllableSequenceLength));
    }

}

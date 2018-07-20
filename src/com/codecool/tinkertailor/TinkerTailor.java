package com.codecool.tinkertailor;

import java.util.*;

public class TinkerTailor {

    public static List<Integer> playGameLinkedList(int playerNumber, int syllableSequenceLength) {
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

    public static List<Integer> playGameArrayList(int playerNumber, int syllableSequenceLength) {
        List<Integer> players = new ArrayList<>(playerNumber);

        for (int i = 0; i < playerNumber; i++) {
            players.add(i + 1);
        }

        List<Integer> outcome = new ArrayList<>(playerNumber);
        int indexToCopyFrom = -1;

        while (outcome.size() != playerNumber) {
            indexToCopyFrom += syllableSequenceLength;
            while (players.get(indexToCopyFrom % playerNumber) == 0) {
                indexToCopyFrom++;
            }
            outcome.add(players.get(indexToCopyFrom % playerNumber));
            players.set(indexToCopyFrom % playerNumber, 0);
        }

        return outcome;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(playGameLinkedList(20, 3));
        System.out.println("With LinkedList it took: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(playGameArrayList(20, 3));
        System.out.println("With ArrayList it took: " + (System.currentTimeMillis() - startTime) + "ms");
    }

}

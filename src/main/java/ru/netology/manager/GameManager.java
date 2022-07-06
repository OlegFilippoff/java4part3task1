package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GameManager {
    HashMap<String, Integer> players = new HashMap<>();

    public GameManager() {
    }

    public void register(Player player) {
        String key = player.getPlayerName();
        int value = player.getPlayerStrength();
        players.put(key, value);
    }


    public boolean isRegistered(String playerName) {
        for (String key : players.keySet()
        ) {
            if (playerName.equals(key)) {
                return true;
            }

        }
        return false;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        int player1Strength = 0;
        int player2Strength = 0;

        for (String key:
             players.keySet()) {
            if (isRegistered(playerName1))
            player1Strength = players.get(playerName1);
        }
        for (String key:
             players.keySet()) {
            if (isRegistered(playerName2))
            player2Strength = players.get(playerName2);
        }
        if (!isRegistered(playerName1) || !isRegistered(playerName2)) {
            throw new NotRegisteredException("One of the Players is not registered yet");
        }

        if (player1Strength > player2Strength) {
            System.out.println(1 + ":0 Победа первого игрока");
            return 1;
        } else if (player1Strength < player2Strength) {
            System.out.println(0 + ":2 Победа второго игрока");
            return 2;
        } else {
            System.out.println(0 + ":0 Ничья");
            return 0;
        }
    }
}

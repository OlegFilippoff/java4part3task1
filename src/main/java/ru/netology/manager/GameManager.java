package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameManager {
    List<Player> players = new ArrayList<>();

    public GameManager() {
    }

    public void register(Player player) {
        players.add(player);
    }

    public boolean matches(String name) {
        for (Player player : players
        ) {
            if (player.getPlayerName().equals(name)) {
                return true;
            }

        }
        return false;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        int player1Strength = 0;
        int player2Strength = 0;

        for (Player player : players
        ) {
            if (player.getPlayerName().equals(playerName1)) {
                player1Strength = player.getPlayerStrength();
            }
            if (player.getPlayerName().equals(playerName2)) {
                player2Strength = player.getPlayerStrength();
            } else if (!matches(playerName1) || !matches(playerName2)) {
                throw new NotRegisteredException("One of the Players is not registered yet");
            }
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

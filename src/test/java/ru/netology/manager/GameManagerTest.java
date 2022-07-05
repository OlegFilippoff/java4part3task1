package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    Player player1 = new Player(1,"Abarth", 30);
    Player player2 = new Player(2,"Bob", 15);
    Player player3 = new Player(3,"Cecil", 17);
    Player player4 = new Player(4,"Dillan", 11);
    Player player5 = new Player(5,"Edith", 5);
    Player player6 = new Player(6,"Mary", 15);

    List<Player> players = new ArrayList<>();
    GameManager manager = new GameManager();


    @Test
    void register() {
        manager.register(player1);
        manager.register(player2);
        int actual = manager.players.size();
        int expected = 2;
        assertEquals(expected,actual);

    }

    @Test
    void roundReturns1() throws NotRegisteredException {
        manager.register(player3);
        manager.register(player1);
        manager.register(player2);
        manager.register(player4);
        int expected = 1;
        int actual = manager.round("Cecil","Dillan");
        assertEquals(expected, actual);
    }
    @Test
    void roundReturns2() throws NotRegisteredException {
        manager.register(player3);
        manager.register(player1);
        manager.register(player2);
        manager.register(player4);
        int expected = 2;
        int actual = manager.round("Dillan","Bob");
        assertEquals(expected, actual);
    }

    @Test
    void roundReturns0() throws NotRegisteredException {
        manager.register(player3);
        manager.register(player1);
        manager.register(player2);
        manager.register(player4);
        manager.register(player6);
        int expected = 0;
        int actual = manager.round("Mary","Bob");
        assertEquals(expected, actual);
    }

    @Test
    void roundReturnsException() throws NotRegisteredException {
        manager.register(player3);
        manager.register(player1);
        manager.register(player2);
        manager.register(player4);
        manager.register(player6);

        assertThrows(NotRegisteredException.class, () -> manager.round("Fedor","Bob"));

    }
}
package ru.netology.team;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

//    @Test
//    public void shouldAddMoreOneGame() {
//
//        GameStore store = new GameStore();
//        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Гонки");
//        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        assertTrue(store.containsGame(game1));
//        assertTrue(store.containsGame(game2));
//        assertTrue(store.containsGame(game3));
//    }
//
//
//
//
//    @Test
//    public void getPlayerBestTime() {
//
//        GameStore store = new GameStore();
//
////        store.addPlayTime("Vova", 11);
////        store.addPlayTime("Ola", 5);
//        store.addPlayTime("Tola", 15);
//
//        String expected = "Tola";
//        String actual = store.getMostPlayer();
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void playerNotFound() {
//
//        GameStore store = new GameStore();
//
//        String expected = null;
//        String actual = store.getMostPlayer();
//        assertEquals(expected, actual);
//
//
//    }
//
//    @Test
//    public void getSumPlayedTimePlayers() {
//
//        GameStore store = new GameStore();
//
//        store.addPlayTime("Olja", 2);
//        store.addPlayTime("Tolja", 4);
//        store.addPlayTime("Vova", 7);
//
//        int expected = 13;
//        int actual = store.getSumPlayedTime();
//
//        Assertions.assertEquals(expected, actual);
//
//    }
//
//    @Test
//    public void getSumPlayedTimePlayer() {
//
//        GameStore store = new GameStore();
//
//        store.addPlayTime("Vova", 5);
//        store.addPlayTime("Vova", 7);
//        store.addPlayTime("Vova", 5);
//
//        int expected = 17;
//        int actual = store.getSumPlayedTime();
//
//        Assertions.assertEquals(expected, actual);
//
//    }
//    @Test
//    public void shouldAddGameThatIsAlreadyInTheCatalog() {
//
//        GameStore store = new GameStore();
//        store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//
//        assertTrue(store.containsGame(store.publishGame("Нетология Баттл Онлайн", "Аркады")));
//    }

}

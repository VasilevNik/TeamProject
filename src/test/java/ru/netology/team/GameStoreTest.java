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

    @Test
    public void shouldAddSeveralIdenticalGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void noGameInTheCatalog() {

        GameStore store = new GameStore();

        assertFalse(store.containsGame(null));
    }

    @Test
    public void shouldAddGameThatIsAlreadyInTheCatalog() {

        GameStore store = new GameStore();
        store.publishGame("Нетология Баттл Онлайн", "Аркады");


        assertTrue(store.containsGame(store.publishGame("Нетология Баттл Онлайн", "Аркады")));
    }

    @Test
    public void shouldAddGameThatIsNotInTheCatalog() {

        GameStore store = new GameStore();
        store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertFalse(store.containsGame(store.publishGame("Морской Бой", "Аркады")));
    }

    @Test
    public void shouldAddGameWithTheSameNameButDifferentGenre() {

        GameStore store = new GameStore();
        store.publishGame("Нетология Баттл Онлайн", "Аркады");


        assertFalse(store.containsGame(store.publishGame("Нетология Баттл Онлайн", "Стратегии")));
    }

    @Test
    public void findPlayerWhoPlayedTheGameForOneHour() {

        GameStore store = new GameStore();
        store.addPlayTime("Kolya",1);

        String expected = "Kolya";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findPlayerWhoPlayedTheGameMostTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Kolya",1);
        store.addPlayTime("Dima", 2);

        String expected = "Dima";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findPlayersWhoHaveNotPlayedTheGameInThisCatalog() {

        GameStore store = new GameStore();
        store.addPlayTime("Sasha",0);

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sumUpTotalAmountOfTimeAllPlayersSpentPlayingTheGame() {

        GameStore store = new GameStore();
        store.addPlayTime("Kolya",1);
        store.addPlayTime("Dima", 2);

        int expected = 3;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registerTheAmountOfTimeOfNewPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Zhenya", 7);

        int expected = 7;
        int actual = store.playedTime.get("Zhenya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registerTheAmountOfTimeAnExistingPlayerHas() {

        GameStore store = new GameStore();

        store.playedTime.put("Zhenya", 1);
        store.addPlayTime("Zhenya", 7);


        int expected = 8;
        int actual = store.playedTime.get("Zhenya");

        Assertions.assertEquals(expected, actual);
    }

    // другие ваши тесты
}
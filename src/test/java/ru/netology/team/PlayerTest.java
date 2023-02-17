package ru.netology.team;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.PanelUI;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    // другие ваши тесты

    @Test
    public void shouldSumGenreIfMoreOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.play(game, 5);

        int expected = 8;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void installOneGame(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");

        player.installGame(game);


        int expected = 0;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);

    }

    @Test
    public void installAndPlayOneGame(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);

        int expected = 5;
        int actual = player.play(game,5);
        assertEquals(expected, actual);

    }

    @Test
    public void installOneGameAndPlayAnotherGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 5);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);


    }

    @Test
    public void addTheSameGameToThePlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game2);

        int expected = 3;
        int actual = player.sumGenre(game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void installOneGameAndPlayAnotherGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 5);

        int expected = 5;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void installOneGameAndInstallAnotherGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);
        player.play(game1, 5);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);

    }

    @Test
    public void installOneGameAndInstallAnotherGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);
        player.play(game1, 5);

        int expected = 5;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void gameIsNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.play(game, 3);


        Assertions.assertThrows(RuntimeException.class, () ->
                player.play(game,5));
    }

    @Test
    public void shouldSumGenreAndPlayAnotherGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);
        player.play(game, 4);
        player.installGame(game1);
        player.play(game1, 5);

        int expected = 7;
        int actual = player.sumGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnGameWithMaxHours() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 7);
        player.play(game2, 5);


        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(game1, actual);
    }

    @Test
    public void shouldReturnGameWithEqualHours() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 7);
        player.play(game2, 7);


        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(game1, actual);
    }

    @Test
    public void notPlayedGameOfGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 3);
        player.play(game1, 7);
        player.play(game2, 5);


        Game expected = null;
        Game actual = player.mostPlayerByGenre("Гонки");
        assertEquals(expected, actual);
    }

    @Test
    public void notPlayedGameOfGenreButInstall() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Гонки");
        Game game2 = store.publishGame("Нетология Баттл Онлайн", "Гонки");

        Player player = new Player("Petya");

        player.installGame(game);
        player.play(game, 3);
        player.installGame(game1);
        player.installGame(game2);
        Game expected = null;

        Game actual = player.mostPlayerByGenre("Гонки");
        assertEquals(expected, actual);
    }

}

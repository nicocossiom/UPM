package es.upm.pproject.sokoban.view;

import java.io.File;

import javafx.scene.media.AudioClip;

public class SokobanSounds {

    public static void playWallSound() {
        AudioClip wallSound = new AudioClip(new File("resources/audio/wall.wav").toURI().toString());
        wallSound.play();
    }

    public static void playCorrectSound() {
        AudioClip wallSound = new AudioClip(new File("resources/audio/found.wav").toURI().toString());
        wallSound.play();
    }

    public static void playBoxMovingSound() {
        AudioClip wallSound = new AudioClip(new File("resources/audio/box.wav").toURI().toString());
        wallSound.play();
    }

    public static void playPlayerMovingSound() {
        AudioClip wallSound = new AudioClip(new File("resources/audio/normalMove.wav").toURI().toString());
        wallSound.play();
    }

    public static void playWinnerSound() {
        AudioClip wallSound = new AudioClip(new File("resources/audio/winner.mp3").toURI().toString());
        wallSound.play();
    }
}

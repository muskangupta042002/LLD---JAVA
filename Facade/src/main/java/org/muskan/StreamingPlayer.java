package org.muskan;

public class StreamingPlayer {
    int currentChapter;
    Amplifier amplifier;
    String movie;

    String description;

    public StreamingPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }

    public void on(){
        System.out.println(description + " turn on");
    }

    public void off(){
        System.out.println(description + " turn off");
    }

    public void pause() {
        System.out.println(description + " paused " + movie);
    }

    public void play(String movie) {
        this.movie = movie;
        currentChapter = 0;
        System.out.println(description + " playing \"" + movie + "\"");
    }

    public void stop() {
        currentChapter = 0;
        System.out.println(description + " stopped \"" + movie + "\"");
    }

    public void setTwoChannelAudio() {
        System.out.println(description + " set two channel audio");
    }

    public void setSurroundAudio() {
        System.out.println(description + " set surround audio");
    }

    @Override
    public String toString() {
        return description ;
    }

}

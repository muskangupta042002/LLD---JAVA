package org.muskan.remote;

public class Stereo {
    String location;
    public Stereo(String location) { this.location=location;}

    public void on(){
        System.out.println(location + " stereo is on");
    }

    public void off(){
        System.out.println(location + " stereo is off");
    }

    public void setCD(){
        System.out.println(location + " stereo is set for CD");
    }public void setDVD(){
        System.out.println(location + " stereo is set for DVD");
    }public void setRadio(){
        System.out.println(location + " stereo is set for Radio");
    }

    public void setVolume(int volume){
        System.out.println(location + " stereo volume set to " +volume);
    }
}

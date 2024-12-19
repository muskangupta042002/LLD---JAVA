package org.muskan;

public class HomeTheatreFacade {
    Amplifier amp;
    Tuner tuner;
    StreamingPlayer player;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheatreFacade(Amplifier amp, Tuner tuner, StreamingPlayer player, Projector projector, TheaterLights lights, Screen screen, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.player = player;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    public void watchMovie(String movie){
        System.out.println("Get ready to watch movie...");
        popper.on();
        popper.pop();
        lights.dim();
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setStreamingPlayer(player);
        amp.setStereoSound();
        amp.setVolume(60);
        player.on();
        player.play(movie);

    }

    public void endMovie(){
        System.out.println("Shutting movie theater down....");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        player.stop();
        player.off();
    }
}

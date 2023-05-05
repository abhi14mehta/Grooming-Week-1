abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void halfTime();
    abstract void endPlay();

    // template method
    public final void play() {
        initialize();
        startPlay();
        halfTime();
        endPlay();
    }
}

class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    void halfTime(){
        System.out.println("Football Game 45 mins over.");
    }

    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

class Cricket extends Game {
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    void halfTime(){
        System.out.println("Cricket Game 1st Innings is completed!");
    }

    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

public class TemplateMethodPattern {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

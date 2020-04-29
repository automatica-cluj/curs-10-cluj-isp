package isp.curs5.factory.games;

//Abstract Factory design pattern

interface Obstacle {
    void action();
}

interface Player {
    void interactWith(Obstacle o);
}

class Kitty implements Player {
    public void interactWith(Obstacle ob) {
        System.out.print("Kitty has encountered a ");
        ob.action();
    }
}

class KungFuGuy implements Player {
    public void interactWith(Obstacle ob) {
        System.out.print("KungFuGuy now battles a ");
        ob.action();
    }
}

class Puzzle implements Obstacle {
    public void action() {
        System.out.println("Puzzle");
    }
}

class NastyWeapon implements Obstacle {
    public void action() {
        System.out.println("NastyWeapon");
    }
}

// The Abstract Factory:
interface GameElementFactory {
    Player makePlayer();
    Obstacle makeObstacle();
}

// Concrete factories:
class KittiesAndPuzzles
        implements GameElementFactory {
    public Player makePlayer() {
        return new Kitty();
    }
    public Obstacle makeObstacle() {
        return new Puzzle();
    }
}

class KillAndDismember
        implements GameElementFactory {
    public Player makePlayer() {
        return new KungFuGuy();
    }
    public Obstacle makeObstacle() {
        return new NastyWeapon();
    }
}

class GameEnvironment {
    private GameElementFactory gef;
    private Player p;
    private Obstacle ob;
    public GameEnvironment(
            GameElementFactory factory) {
        gef = factory;
        p = factory.makePlayer();
        ob = factory.makeObstacle();
    }
    public void play() { p.interactWith(ob); }
}


public class Games {
    public static void main(String[] args) {
        GameElementFactory
                kp = new KittiesAndPuzzles(),
                kd = new KillAndDismember();
        GameEnvironment
                g1 = new GameEnvironment(kp),
                g2 = new GameEnvironment(kd);

        g1.play();
        g2.play();

    }
}

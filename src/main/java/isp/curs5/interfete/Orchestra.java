package isp.curs5.interfete;

import java.util.Random;

enum DENUMIRE_NOTA {
    DO, RE, MI, FA, SO, LA, SI;
}

interface  Instrument{
    Random RANDOM = new Random();

    void play(NotaMuzicala nota);

    public static NotaMuzicala GenereazaNota(){
        int k = RANDOM.nextInt(DENUMIRE_NOTA.values().length);
        return new NotaMuzicala(DENUMIRE_NOTA.values()[k]);
    }
}

class Pian implements Instrument{

    @Override
    public void play(NotaMuzicala nota) {
        System.out.println("Pianul canta nota "+nota);
    }
}

class Vioara implements Instrument{

    @Override
    public void play(NotaMuzicala nota) {
        System.out.println("Vioara canta nota "+nota);
    }
}

class NotaMuzicala{
    private DENUMIRE_NOTA nota;

    public NotaMuzicala(DENUMIRE_NOTA nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "NotaMuzicala{" +
                "note=" + nota +
                '}';
    }
}


public class Orchestra {

    public static void main(String[] args) {
        Instrument[] instrumente = new Instrument[10];
        instrumente[0] = new Pian();
        instrumente[1] = new Vioara();
        instrumente[2] = new Vioara();

        for(Instrument i: instrumente)
            if(i != null)
                i.play(Instrument.GenereazaNota());

    }
}

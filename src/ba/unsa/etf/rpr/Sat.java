package ba.unsa.etf.rpr;

public class Sat {
    private int sati, minute, sekunde;

    public Sat(int sati, int minute, int sekunde) {
        postavi(sati, minute, sekunde);
    }

    public void postavi(int sati, int minute, int sekunde) throws IllegalArgumentException {
        if (sati >= 24 || sati < 0) throw new IllegalArgumentException("Sati van opsega");
        else if (minute >= 60 || minute < 0) throw new IllegalArgumentException("Minute van opsega");
        else if (sekunde >= 60 || sekunde < 0) throw new IllegalArgumentException("Sekunde van opsega");
        this.sati = sati;
        this.minute = minute;
        this.sekunde = sekunde;
    }

    public void sljedeci() {
        sekunde = sekunde + 1;

        if (sekunde == 60) {
            minute = minute + 1;
            sekunde = 0;
        }
        if (minute == 60) {
            sati = sati + 1;
            minute = 0;
        }
        if (sati == 24) {
            sati = 0;
        }
    }

    public void prethodni() {
        sekunde = sekunde - 1;

        if (sekunde == -1) {
            minute = minute - 1;
            sekunde = 59;
        }
        if (minute == -1) {
            sati = sati - 1;
            minute = 59;
        }
        if (sati == -1) {
            sati = 23;
        }
    }

    void pomjeriZa(int pomak) {
        if (pomak > 0) {
            for (int i = 0; i < pomak; ++i) sljedeci();
        }
        else {
            for (int i = 0; i < -pomak; ++i) prethodni();
        }
    }

    public void ispisi() {
        System.out.println(sati + ":" + minute + ":" + sekunde);
    }

    public int getSati() {
        return sati;
    }

    public int getMinute() {
        return minute;
    }

    public int getSekunde() {
        return sekunde;
    }
}

package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SatTest {
    @Test
    void testIzuzetkaCtora() {
        IllegalArgumentException izuzetakZaSate = assertThrows(IllegalArgumentException.class, () -> { new Sat(-2,-2,-2); });
        IllegalArgumentException izuzetakZaMinute = assertThrows(IllegalArgumentException.class, () -> { new Sat(23,75,-2); });
        IllegalArgumentException izuzetakZaSekunde = assertThrows(IllegalArgumentException.class, () -> { new Sat(12,12,60); });
        //provjera poruke izuzetka
        assertEquals("Sati van opsega", izuzetakZaSate.getMessage());
        assertEquals("Minute van opsega", izuzetakZaMinute.getMessage());
        assertEquals("Sekunde van opsega", izuzetakZaSekunde.getMessage());
    }

    @Test
    void sljedeci() {
        Sat s = new Sat(23,59,59);
        s.sljedeci();
        assertEquals("0:0:0", "" + s);
    }

    @Test
    void prethodni() {
        Sat s = new Sat(0,0,0);
        s.prethodni();
        assertEquals(59, s.getSekunde());
        assertEquals(59, s.getMinute());
        assertEquals(23, s.getSati());
    }

    @Test
    void pomjeriZa() {
        Sat s = new Sat(23,59,59);
        s.pomjeriZa(-86400);
        assertEquals("23:59:59", "" + s);
        s.pomjeriZa(2);
        assertEquals(0, s.getSati());
        assertEquals(0, s.getMinute());
        assertEquals(1, s.getSekunde());
    }

    @Test
    void ispisi() {
        Sat s = new Sat(23,0, 9);
        assertEquals("23:0:9", s.toString());
    }

    @Test
    void getSati() {
        Sat s = new Sat(12, 0, 0);
        s.pomjeriZa(7200);
        assertEquals(14, s.getSati());
    }

    @Test
    void getMinute() {
        Sat s = new Sat(12, 0, 0);
        s.pomjeriZa(7320);
        assertEquals(2, s.getMinute());
    }

    @Test
    void getSekunde() {
        Sat s = new Sat(12, 0, 0);
        s.pomjeriZa(7349);
        assertEquals(29, s.getSekunde());
    }
}

package ohtu.intjoukkosovellus;

public class IntJoukko {

    private int[] ljono;  
    private int kasvatuskoko = 5;
    private int alkioidenLkm = 0; 

    public IntJoukko() {
        ljono = new int[5];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Negatiivinen kapasiteetti tai ");
        }
        ljono = new int[kapasiteetti];
        for (int i = 0; i < ljono.length; i++) {
            ljono[i] = 0;
        }
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            ljono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == ljono.length) {
                kasvaTaulukonKokoa();
            }
            return true;
        }
        return false;
    }

    public void kasvaTaulukonKokoa() {
        int[] uusi = new int[ljono.length + kasvatuskoko];
        ljono = kopioiTaulukko(ljono, uusi);
    }


    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == ljono[i]) {
                ljono[i] = 0;
                siirraArvoja(i);
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    public void siirraArvoja(int i) {
        for (; i < alkioidenLkm - 1; i++) {
            ljono[i] = ljono[i + 1];
            ljono[i + 1] = 0;
        }
    }

    private int[] kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
        return uusi;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        String mjono = "{";
        if (alkioidenLkm >= 1) {
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                mjono += ljono[i];
                mjono += ", ";
            }
            mjono += ljono[alkioidenLkm - 1];
        }
        mjono += "}";
        return mjono;   
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = ljono[i];
        }
        return taulu;
    }
    

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            a.lisaa(bTaulu[i]);
        }
        return a;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < bTaulu.length; i++) {
            a.poista(b.ljono[i]);
        }
        return a;
    }
        
}

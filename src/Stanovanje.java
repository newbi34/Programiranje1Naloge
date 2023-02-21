
public class Stanovanje {

    private Oseba[] stanovalci;
    private Stanovanje sosed;

    public Stanovanje(Oseba[] stanovalci) {
        this.stanovalci = stanovalci;
    }

    public int steviloStanovalcev() {
        int counter = 0;
        for (int i = 0; i < this.stanovalci.length; i++) {
            counter++;
        }
        return counter;
    }

    public int steviloStarejsihOd(Oseba os) {
        int counter = 0;
        for (Oseba prva : this.stanovalci) {
            if (prva.vrniStarost() > os.vrniStarost()) {
                counter++;
            }
        }
        return counter;
    }

    public int[] mz() {
        int[] mz = new int[2];
        int counter = 0;
        for (Oseba os : this.stanovalci) {
            if (os.vrniSpol() == 'M') {
                counter++;
            }
        }
        mz[0] = counter;
        mz[1] = this.stanovalci.length - counter;
        return mz;
    }

    public Oseba starosta() {
        int indexNajStarejse = 0;
        for (int i = 1; i < this.stanovalci.length; i++) {
            if (stanovalci[i].vrniStarost() > stanovalci[i-1].vrniStarost()) {
                indexNajStarejse = i;
            }
        }
        return stanovalci[indexNajStarejse];
    }

    public void nastaviSosede(Stanovanje levi, Stanovanje zgornji,
            Stanovanje desni, Stanovanje spodnji) {
        // dopolnite ...
    }

    public Oseba starostaSosescine() {
        // dopolnite/popravite ...
        return null;
    }

    public Oseba[] sosedjeSosedov() {
        // dopolnite/popravite ...
        return null;
    }
}

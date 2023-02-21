
public class Premica {

    private double k;
    private double n;

    public Premica(double k, double n) {
        this.k = k;
        this.n = n;
    }

    public double vrniK() {
        return this.k;
    }

    public double vrniN() {
        return this.n;
    }

    public String toString() {
        return String.format(" y = %f x + %f", k, n);
    }

    public Tocka tockaPriX(double x) {
        Tocka t = new Tocka(x, this.k * x + this.n);
        return t;
    }

    public static Premica skoziTocko(double k, Tocka t) {
        Premica p = new Premica(k, t.vrniY() - k * t.vrniX());
        return p;
    }

    public Premica vzporednica(Tocka t) {
        Premica p = new Premica(this.k, t.vrniY() - this.k * t.vrniX());
        return p;
    }

    public Premica pravokotnica(Tocka t) {
        Premica p = new Premica((-1 / this.k), t.vrniY() - this.k * t.vrniX());
        return p;
    }

    public Tocka presecisce(Premica p, double epsilon) {
        double x = (p.n - this.n) / (this.k - p.k);
        Tocka t = new Tocka(x, this.k * x + this.n);
        if (Math.abs(p.k - k) < epsilon) {
            return null;
        } else {
            return t; 
        }
    }

    public Tocka projekcija(Tocka t) {
        Premica p = new Premica(-1 / this.k, t.vrniY() + (1 / this.k) * t.vrniX());
        return this.presecisce(p, 0.0);
    }

    public double razdalja(Tocka t) {
        Tocka p = this.projekcija(t);
        return p.razdalja(t);
    }

    public double razdaljaOdIzhodisca() {
        Tocka izhodisce = new Tocka(0 ,0);
        return this.razdalja(izhodisce);
    }

    public double razdalja(double n) {
        Premica pravokotnica = new Premica((-1 / this.k), 0);
        Premica pQ = new Premica(this.k, n);
        Tocka p = pravokotnica.presecisce(this, 0);
        Tocka q = pravokotnica.presecisce(pQ, n);
        return p.razdalja(q);
    }
}

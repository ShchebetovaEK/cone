package by.tms.figure.entity;

public class ConeParameters {

    private final double coneSquare;
    private final double coneVolume;

    public ConeParameters(double coneSquare, double coneVolume) {
        this.coneSquare = coneSquare;
        this.coneVolume = coneVolume;
    }

    public double getConeSquare() {
        return coneSquare;
    }

    public double getConeVolume() {
        return coneVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConeParameters that = (ConeParameters) o;

        if (Double.compare(that.coneSquare, coneSquare) != 0) return false;
        return Double.compare(that.coneVolume, coneVolume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(coneSquare);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coneVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConeParameters{");
        sb.append("coneSquare=").append(coneSquare);
        sb.append(", coneVolume=").append(coneVolume);
        sb.append('}');
        return sb.toString();
    }
}

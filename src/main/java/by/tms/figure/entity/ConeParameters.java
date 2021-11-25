package by.tms.figure.entity;

public class ConeParameters {

    private double coneSquare;
    private double coneVolume;

    public double getConeSquare() {
        return coneSquare;
    }

    public void setConeSquare(double coneSquare) {
        this.coneSquare = coneSquare;
    }

    public double getConeVolume() {
        return coneVolume;
    }

    public void setConeVolume(double coneVolume) {
        this.coneVolume = coneVolume;
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

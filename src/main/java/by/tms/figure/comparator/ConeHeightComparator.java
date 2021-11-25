package by.tms.figure.comparator;

import by.tms.figure.entity.Cone;

import java.util.Comparator;

public class ConeHeightComparator implements Comparator<Cone> {

    @Override
    public int compare(Cone o1, Cone o2) {
        return Double.compare(o1.getHeight(), o2.getHeight());
    }
}

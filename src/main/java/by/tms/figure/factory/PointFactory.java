package by.tms.figure.factory;

import by.tms.figure.entity.Point;

public class PointFactory implements  EntityFactory<Point>{

    @Override
    public Point create() {
        return new Point();
    }
}

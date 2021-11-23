package by.tms.factory;

import by.tms.entity.Point;

public class PointFactory implements  EntityFactory<Point>{
    @Override
    public Point create() {
        return new Point();
    }
}

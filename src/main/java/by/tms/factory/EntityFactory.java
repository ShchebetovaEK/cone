package by.tms.factory;

import by.tms.entity.Figure;

public interface EntityFactory <T extends Figure> {

    T create();


}

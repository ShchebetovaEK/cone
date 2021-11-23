package by.tms.mapper;

import by.tms.entity.Cone;
import by.tms.entity.Point;
import by.tms.factory.ConeFactory;
import by.tms.factory.PointFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConeInputMapper {

    private static final Logger logger = LogManager.getLogger();
    private ConeFactory coneFactory;
    private PointFactory pointFactory;

    public ConeInputMapper(ConeFactory coneFactory, PointFactory pointFactory) {
        this.coneFactory = coneFactory;
        this.pointFactory = pointFactory;
    }

    private static final String SEPARATOR = ",";

    public List<String> mapToStringParams(String line){
        logger.debug("mapToStringParams was executed");
        return Stream.of(line.split(SEPARATOR)).collect(Collectors.toList());
    }


    public List<Double> mapToIntParams(List<String> params){
        return params.stream().map(this::parseDouble).collect(Collectors.toList());
    }

    public Cone mapToCone(List<Double> params){
        Point point = pointFactory.create();
        point.setX(params.get(0));
        point.setY(params.get(1));
        point.setZ(params.get(2));
        Cone cone = coneFactory.create();
        cone.setConeId(UUID.randomUUID());
        cone.setCenter(point);
        cone.setRadius(params.get(3));
        cone.setHeight(params.get(4));
        logger.info("mapToCone successful" + cone  );
        return cone;

    }

    private Double parseDouble(String param){
        try {
            return Double.parseDouble(param);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return  null;
        }
    }


}

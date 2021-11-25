package by.tms.figure.validator;

import java.util.List;
import java.util.Objects;

public class ConeInputValidator {

    private static final int VALID_PARAMS_COUNT = 5;

    public boolean validateParameterCount(List<String> params){
        return params.size() == VALID_PARAMS_COUNT;

    }

    public boolean validateParameters(List<Double> params){
        return params.stream().noneMatch(Objects::isNull);
    }
//todo
//    public boolean validateConeHeight(double height){
//        return height > 0;

//    }
//todo
//    public boolean validateConeRadius(double radius){
//        return  radius > 0;
//    }


}

package by.tms.figure.validator;

import java.util.List;


public class ConeInputValidator {

    private static final int VALID_PARAMS_COUNT = 5;

    public boolean validateParameterCount(List<String> params){
        return params.size() == VALID_PARAMS_COUNT;

    }

    public boolean validateParameters(List<Double> params){
        return params.stream().noneMatch(a -> a == Double.NaN );
    }

    public boolean validateConeRadius(List<Double> params){
        return params.get(3) > 0;
    }

    public boolean validateConeHeight(List<Double> params){
        return params.get(4) > 0;

    }


}

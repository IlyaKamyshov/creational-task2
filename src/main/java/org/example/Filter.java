package org.example;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        source.forEach(i -> {
            if (i < treshold) {
                logger.log("Элемент \"" + i + "\" не проходит");
            } else {
                logger.log("Элемент \"" + i + "\" проходит");
                result.add(i);
            }
        });
        return result;
    }
}

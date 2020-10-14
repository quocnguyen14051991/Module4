package service.impl;

import org.springframework.stereotype.Service;
import service.Sum;
@Service
public class SumImpl implements Sum {
    @Override
    public double sum(double a) {
        return a*23000;
    }
}

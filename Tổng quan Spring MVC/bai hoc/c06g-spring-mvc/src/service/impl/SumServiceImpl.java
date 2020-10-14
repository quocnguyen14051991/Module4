package service.impl;

import org.springframework.stereotype.Service;
import service.SumService;

@Service
public class SumServiceImpl implements SumService {

    @Override
    public double sum2Num(double num1, double num2) {
        return num1 + num2;
    }
}

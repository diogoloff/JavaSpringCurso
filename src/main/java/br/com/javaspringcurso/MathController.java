package br.com.javaspringcurso;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaspringcurso.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)    
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if ((!isNumeric(numberOne)) || (!isNumeric(numberTwo))) {
            throw new UnsupportedMathOperationException("Você informou um valor errado!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String lsNum) {

        String number = lsNum.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String lsNum) {

        if (lsNum == null)
            return false;

        String number = lsNum.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

}

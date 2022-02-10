package edu.eci.cvds.tdd.aerodescuentos;
import org.junit.Assert;
import org.junit.Test;

import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

public class TarifasTest {
    //diasAntelacion>20
    @Test
     public void validateNotDiscountDaysAdvance() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 20);

        Assert.assertEquals( 300000, result, 0);
    }
    @Test
    public void validateDiscountDaysAdvance() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 20, 20);

        Assert.assertEquals( 255000, result, 0);
    }
    @Test
    public void validateDiscountDaysAdvance1() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 20);

        Assert.assertEquals( 300000, result, 0);
    }
    //0<Edad<18
    @Test
    public void validateMajorAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 20);

        Assert.assertEquals( 300000, result, 0);
    }


}

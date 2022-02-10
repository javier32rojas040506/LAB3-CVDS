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

        Assert.assertEquals( 300000, result, 0);
    }
    @Test
    public void validateDiscountDaysAdvance1() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 20);

        Assert.assertEquals( 300000, result, 0);
    }
    //0<Edad<18
    @Test
    public void validateUnderAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 17);

        Assert.assertEquals( 285000, result, 0);
    }
    @Test
    public void validateExactAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 18);

        Assert.assertEquals( 300000, result, 0);
    }
    @Test
    public void validateOverAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 19);

        Assert.assertEquals( 300000, result, 0);
    }
    //Edad<65
    @Test
    public void validateUnderThirdAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 64);

        Assert.assertEquals( 300000, result, 0);
    }
    @Test
    public void validateExactThirdAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 65);

        Assert.assertEquals( 300000, result, 0);
    }
    @Test
    public void validateOverThirdAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 19, 66);

        Assert.assertEquals( 276000, result, 0);
    }
    //diasAntelacion>20 & 0<Edad<18
    @Test
    public void validateAccumulativeUnderAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 21, 17);

        Assert.assertEquals( 240000, result, 0);
    }
    //diasAntelacion>20 & Edad>65
    @Test
    public void validateAccumulativeThirdAge() {

        double result = CalculadorDescuentos.calculoTarifa(300000, 21, 66);

        Assert.assertEquals( 231000, result, 0);
    }
}

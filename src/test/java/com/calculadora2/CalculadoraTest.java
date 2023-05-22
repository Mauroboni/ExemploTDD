package com.calculadora2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTest {
    
    Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void verficarSoma()
    {
        assertEquals(5,calculadora.somar(2,3),"O resultado calculado é diferente do resultado esperado!");
    }

    @Test
    public void verificarSubtracao(){
        assertEquals(-1, calculadora.subtrair(2, 3), "O resultado calculado é diferente do resultado esperado!");

    }

    @Test
    public void verificarMultiplicacao() {
        assertEquals(6, calculadora.multiplicar(2, 3), "O resultado calculado é diferente do resultado esperado!");

    }

    @Test
    public void verificarDivisao() {
        assertEquals(2, calculadora.dividir(5, 2), "O resultado calculado é diferente do resultado esperado!");

    }

    @Test
    public void verificarDivisaoPorZero() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.dividir(5, 0);
        });
        assertEquals("Não possível fazer a divisão, pois o divisor é igual a zero!", exception.getMessage());
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101",
            "3,   78,  81",
            "1,    -2, -1",
            "2147483646, 1, 2147483647",
            "2147483646, 0, 2147483646"
    })
    void somarVariosInteiros(int primeiraParcela, int segundaParcela, int resultadoEsperado) {
        assertEquals(
                resultadoEsperado, calculadora.somar(
                        primeiraParcela,
                        segundaParcela),
                () -> primeiraParcela + " + " + segundaParcela + " deveria ser igual a " + resultadoEsperado);
    }

    @Test
    public void somaDeveriaDispararUmaExcecao() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.somar(2147483647, 2);
        });
        assertEquals("As parcelas não podem ser iguais ou maiores que 2.147.483.647!", exception.getMessage());

    }




}

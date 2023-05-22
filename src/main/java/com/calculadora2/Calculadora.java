package com.calculadora2;

public class Calculadora {

    public int subtrair(int a, int b){
        return a-b;
    }

    public int multiplicar(int a, int b) {
        return a*b;
    }
    
    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Não possível fazer a divisão, pois o divisor é igual a zero!");
        } else {
            return dividendo / divisor;
        }
    }

   public int somar(int parcela1, int parcela2) {
       if (parcela1 > Integer.MAX_VALUE || parcela2 > Integer.MAX_VALUE) {
           throw new IllegalArgumentException("As parcelas não podem ser iguais ou maiores que 2.147.483.647!");
       } else {
           return parcela1 + parcela2;
       }
   }



}

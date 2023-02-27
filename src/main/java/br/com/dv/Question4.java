package br.com.dv;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Question4 {

    public static void doQuestion4() {
        /*
        Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:

        SP — R$67.836,43
        RJ — R$36.678,66
        MG — R$29.229,88
        ES — R$27.165,48
        Outros — R$19.849,53

        Escreva um programa que calcule o percentual de representação
         que cada estado teve no valor total mensal da distribuidora.
         */

        Map<String, BigDecimal> faturamentoPorEstado = new HashMap<>();
        faturamentoPorEstado.put("SP", new BigDecimal("67836.43"));
        faturamentoPorEstado.put("RJ", new BigDecimal("36678.66"));
        faturamentoPorEstado.put("MG", new BigDecimal("29229.88"));
        faturamentoPorEstado.put("ES", new BigDecimal("27165.48"));
        faturamentoPorEstado.put("Outros", new BigDecimal("19849.53"));

        BigDecimal totalFaturamento = getTotalFaturamento(faturamentoPorEstado);
        System.out.println("O faturamento total foi de R$" + totalFaturamento);

        printFaturamentosPorEstado(faturamentoPorEstado, totalFaturamento);
    }

    private static BigDecimal getTotalFaturamento(Map<String, BigDecimal> faturamentoPorEstado) {
        BigDecimal totalFaturamento = BigDecimal.ZERO;
        for (BigDecimal faturamento : faturamentoPorEstado.values()) {
            totalFaturamento = totalFaturamento.add(faturamento);
        }
        return totalFaturamento;
    }

    private static void printFaturamentosPorEstado(Map<String, BigDecimal> faturamentoPorEstado,
                                                   BigDecimal totalFaturamento) {
        for (Map.Entry<String, BigDecimal> entry : faturamentoPorEstado.entrySet()) {
            BigDecimal percentual = entry
                    .getValue()
                    .divide(totalFaturamento, 2, RoundingMode.HALF_UP)
                    .multiply(new BigDecimal("100"));

            System.out.println("O estado " + entry.getKey() + " teve cerca de " +
                    percentual + "% do faturamento total.");
        }
        System.out.println("Observação: os valores foram arredondados para duas casas decimais.");
    }
}

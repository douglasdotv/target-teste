package br.com.dv;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Question3 {
    /*
    Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa que calcule e retorne:
    • O menor valor de faturamento ocorrido em um dia do mês;
    • O maior valor de faturamento ocorrido em um dia do mês;
    • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

    IMPORTANTE:
    a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
    b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
    Estes dias devem ser ignorados no cálculo da média;
     */

    private static final String FILE_PATH = "src/main/resources/dados.json";

    public static void doQuestion3() {
        Faturamento[] faturamentos = readJsonFile(FILE_PATH);

        if (faturamentos == null) {
            return;
        }

        System.out.println("Menor valor de faturamento: " + getMinFaturamento(faturamentos));
        System.out.println("Maior valor de faturamento: " + getMaxFaturamento(faturamentos));
        System.out.println("Número de dias com faturamento superior à média mensal: " +
                getDiasComFaturamentoSuperiorAMedia(faturamentos));
    }

    private static Faturamento[] readJsonFile(String path) {
        File file = new File(path);
        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Faturamento[].class);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo!");
            e.printStackTrace();
        }
        return null;
    }

    private static BigDecimal getMinFaturamento(Faturamento[] faturamentos) {
        BigDecimal minFaturamento = null;

        for (Faturamento faturamento : faturamentos) {
            if (faturamento.getValor().compareTo(BigDecimal.ZERO) != 0) {
                if (minFaturamento == null) {
                    minFaturamento = faturamento.getValor();
                } else if (faturamento.getValor().compareTo(minFaturamento) < 0) {
                    minFaturamento = faturamento.getValor();
                }
            }
        }

        return minFaturamento;
    }

    private static BigDecimal getMaxFaturamento(Faturamento[] faturamentos) {
        BigDecimal maxFaturamento = null;

        for (Faturamento faturamento : faturamentos) {
            if (faturamento.getValor().compareTo(BigDecimal.ZERO) != 0) {
                if (maxFaturamento == null) {
                    maxFaturamento = faturamento.getValor();
                } else if (faturamento.getValor().compareTo(maxFaturamento) > 0) {
                    maxFaturamento = faturamento.getValor();
                }
            }
        }

        return maxFaturamento;
    }

    private static BigDecimal getFaturamentoMedio(Faturamento[] faturamentos) {
        BigDecimal totalFaturamento = BigDecimal.ZERO;
        int dias = 0;

        for (Faturamento faturamento : faturamentos) {
            if (faturamento.getValor().compareTo(BigDecimal.ZERO) != 0) {
                totalFaturamento = totalFaturamento.add(faturamento.getValor());
                dias++;
            }
        }

        return totalFaturamento.divide(BigDecimal.valueOf(dias), 4, RoundingMode.HALF_UP);
    }

    private static int getDiasComFaturamentoSuperiorAMedia(Faturamento[] faturamentos) {
        BigDecimal avg = getFaturamentoMedio(faturamentos);
        int dias = 0;

        for (Faturamento faturamento : faturamentos) {
            if (faturamento.getValor().compareTo(BigDecimal.ZERO) != 0) {
                if (faturamento.getValor().compareTo(avg) > 0) {
                    dias++;
                }
            }
        }

        return dias;
    }

    static class Faturamento {
        private final int dia;
        private final BigDecimal valor;

        public Faturamento(int dia, BigDecimal valor) {
            this.dia = dia;
            this.valor = valor;
        }

        private BigDecimal getValor() {
            return valor;
        }
    }

}

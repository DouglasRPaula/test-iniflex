import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
            new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2 Remover o funcionário “João” da lista.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 Imprimir todos os funcionários com todas suas informações
        System.out.println("Lista de funcionários:");
        funcionarios.forEach(f -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String dataFormatada = f.getDataNascimento().format(formatter);
            System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: %s, Função: %s%n",
                    f.getNome(), dataFormatada, formatarSalario(f.getSalario()), f.getFuncao());
        });

        // 3.4 10% de aumento de salário
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));

        // 3.5 Agrupar os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 Imprimir os funcionários agrupados por função
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(f -> System.out.println("  " + f));
        });

        // 3.8 Imprimir os funcionários que fazem aniversário no mês 10 e 12
        System.out.println("\nFuncionários que fazem aniversário nos meses 10 e 12:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonth() == Month.OCTOBER || f.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(System.out::println);

        // 3.9 Imprimir o funcionário com a maior idade
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparing(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()))
                .orElseThrow();
        System.out.printf("\nFuncionário com a maior idade: %s - Idade: %d anos%n",
                maisVelho.getNome(), Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears());

        // 3.10 Imprimir a lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // 3.11 Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + formatarSalario(totalSalarios));

        // 3.12 Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nQuantidade de salários mínimos por funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal qtdSalariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("%s - %.2f salários mínimos%n", f.getNome(), qtdSalariosMinimos);
        });
    }

    private static String formatarSalario(BigDecimal salario) {
        return salario.setScale(2, RoundingMode.HALF_UP)
                .toString()
                .replace(".", ",");
    }
}
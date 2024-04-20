package Homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
//1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> transactions2011sorted = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(transactions2011sorted);
//2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> uniqueCities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCities);

//3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> tradersFromCambridgeSortedByName = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(tradersFromCambridgeSortedByName);

//4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String traderNamesSorted = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(traderNamesSorted);

//5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean milanTraderExists = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milanTraderExists ? "Трейдер из Милана существует" : "Трейдер из Милана не существует");

////6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int sumOfTransactionsFromCambridge = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println("Сумма всех транзакций трейдеров из Кембриджа: " + sumOfTransactionsFromCambridge);

//7. Какова максимальная сумма среди всех транзакций?
        int maxTransactionValue = transactions.stream().mapToInt((x) -> {
            return x.getValue();
        }).max().getAsInt();
        System.out.println("Максимальная сумма среди всех транзакций: " + maxTransactionValue);

//8. Найти транзакцию с минимальной суммой.
        int minTransactionValue = transactions.stream().mapToInt((x) -> {
            return x.getValue();
        }).min().getAsInt();
        System.out.println("Минимальная сумма среди всех транзакций: " + minTransactionValue);
    }
}

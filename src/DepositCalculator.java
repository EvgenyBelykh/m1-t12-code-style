import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercentFunction(double money, int period ) {
    double pay = money * Math.pow((1 + 0.06 / 12), 12 * period);
    return round( pay);
    }
    double calculateSimplePercentFunction(double amount, int depositPeriod) {
      return round(amount + amount * 0.06 * depositPeriod);
    }
    double round(double value) {
          double scale = Math.pow (10, 2);
          return Math.round(value * scale) / scale;
    }

    void calculateDepositAmount() {
      int period;
      int action;

      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:") ;
      int amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:") ;
      period = scanner.nextInt( );
      System.out.println ("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      action = scanner.nextInt();
      double out = 0;

      if (action == 1) out = calculateSimplePercentFunction(amount, period);
      else if (action == 2) {
          out = calculateComplexPercentFunction(amount, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
    new DepositCalculator().calculateDepositAmount();
}

}

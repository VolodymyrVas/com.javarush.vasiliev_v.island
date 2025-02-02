import entity.Island;
import entity.Location;
import generating.Generating;
import settings.Settings;
import statistic.Statistic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Application {
    public static void main(String[] args) {
        // ТОЧКА СБОРКИ И СТАРТА МОЕГО ПРИЛОЖЕНИЯ

        Island island = new Island(Settings.columnsCount, Settings.rowsCount);
        System.out.print("Создан мир размером: ");
        int y = Settings.columnsCount;
        int x = Settings.rowsCount;
        System.out.println("columnsCount -> " + y + " rowsCount -> " + x);
        System.out.println("#".repeat(77));

//      ГЕНЕРИРУЕМ ФЛОРУ И ФАУНУ
        Generating.generateBiot();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new Generating(), 0, 5, TimeUnit.SECONDS);


//      ВЫВОД В КОНСОЛЬ ПЕРВЫХ ПОСИЛЕНЦЕВ

        System.out.println("#".repeat(77));

    }
}

import entity.AnimalEater;
import entity.AnimalLifeCycle;
import entity.AnimalMover;
import entity.Island;
import generating.Generating;
import settings.Settings;
import statistic.Statistic;
import statistic.StatisticsUpdater;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        Island island = new Island();
        System.out.println("Создан мир размером: columnsCount -> " + Settings.columnsCount +
                                   " rowsCount -> " + Settings.rowsCount);
        System.out.println("#".repeat(77));

        // Генерация биоты один раз
        Generating generating = new Generating(island);
        generating.generateBiot();
        Statistic statistic = new Statistic(island);
        statistic.printStat();// ✅ Первичный вывод статистики

        // Создаём планировщик потоков
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        // 1. Сначала животные едят (каждые 4 сек)
        executorService.scheduleAtFixedRate(new AnimalEater(island), 0, 4, TimeUnit.SECONDS);

        // 2. Потом размножаются (каждые 6 сек, задержка 1 сек после еды)
        executorService.scheduleAtFixedRate(new AnimalLifeCycle(island), 1, 6, TimeUnit.SECONDS);

        // 3. Потом передвигаются (каждые 3 сек, задержка 2 сек после еды)
        executorService.scheduleAtFixedRate(new AnimalMover(island), 2, 3, TimeUnit.SECONDS);

        // ✅ 4. Вывод статистики (каждые 7 сек, после всех действий)
        executorService.scheduleAtFixedRate(new StatisticsUpdater(island), 3, 7, TimeUnit.SECONDS);
    }
}


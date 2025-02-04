import entity.AnimalLifeCycle;
import entity.AnimalMover;
import entity.Island;
import generating.Generating;
import settings.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        Island island = new Island();
        System.out.println("Создан мир размером: columnsCount -> " + Settings.columnsCount +
                                   " rowsCount -> " + Settings.rowsCount);
        System.out.println("#".repeat(77));

        Generating generating = new Generating(island);
        generating.generateBiot();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);

        executorService.scheduleAtFixedRate(new Generating(island), 0, 5, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new AnimalMover(island), 0, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(new AnimalLifeCycle(island), 0, 6, TimeUnit.SECONDS);

        System.out.println("#".repeat(77));
    }
}

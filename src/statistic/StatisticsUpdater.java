package statistic;

import entity.Island;

public class StatisticsUpdater implements Runnable {
    private final Statistic statistic;

    public StatisticsUpdater(Island island) {
        this.statistic = new Statistic(island);
    }

    @Override
    public void run() {
        statistic.printStat(); // ✅ Теперь статистика обновляется каждый такт
        System.out.println("#".repeat(77));
    }
}

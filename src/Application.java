import entity.Island;
import entity.Location;
import entity.creature.animal.predator.Snake;
import generating.Generating;
import settings.Settings;
import statistic.Statistic;


public class Application {
    public static void main(String[] args) throws NoSuchFieldException {
        // ТОЧКА СБОРКИ И СТАРТА МОЕГО ПРИЛОЖЕНИЯ

        Island island = new Island(Settings.columnsCount, Settings.rowsCount);
        System.out.print("Создан мир размером: ");
        int y = 0;
        int x = 0;
        for (int i = 0; i < Settings.columnsCount; i++) {
            y++;
            for (int j = 0; j < Settings.rowsCount; j++) {
                x++;
            }
        }
        x = x / Settings.columnsCount;
        System.out.println("columnsCount -> " + y + " rowsCount -> " + x);
        System.out.println("#".repeat(77));
//      ГЕНЕРИРУЕМ ФЛОРУ И ФАУНУ
        Generating.generateBiot();
//      ВЫВОД В КОНСОЛЬ ПЕРВЫХ ПОСИЛЕНЦЕВ
        Statistic.printStat();

        System.out.println("#".repeat(77));
        Statistic.printCountOfAnimals();

        System.out.println("#".repeat(77));
        Statistic.printCountOfPlants();

        System.out.println("#".repeat(77));
        Location.printArray();
        Location.printWolfsOnCell();
        Location.printArray();


    }
}

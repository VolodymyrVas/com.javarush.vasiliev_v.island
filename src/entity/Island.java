package entity;

import settings.Settings;

public class Island {
    private final Location[][] locations;

    public Island() {
        locations = new Location[Settings.columnsCount][Settings.rowsCount];
        for (int x = 0; x < Settings.columnsCount; x++) {
            for (int y = 0; y < Settings.rowsCount; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
    }

    // Метод для получения ширины острова
    public int getWidth() {
        return locations.length;
    }

    // Метод для получения высоты острова
    public int getHeight() {
        return locations[0].length;
    }

    // Получение конкретной клетки по координатам
    public Location getLocation(int x, int y) {
        return locations[x][y];
    }
}

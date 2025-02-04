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

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }
}

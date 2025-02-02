package entity;

import entity.creature.animal.Animal;
import entity.creature.animal.predator.Snake;
import entity.creature.animal.predator.Wolf;
import generating.Generating;
import settings.Settings;
import statistic.Statistic;

import java.util.Arrays;


public class Location extends Generating{

//    private final Generating generating;
    public Location() {
//        this.generating = new Generating();
//        generating.generateBiot();
    }



    // ЛОКАЦИЯ ДОЛЖНА ЗНАТЬ ТЕКУЩЕЕ КОЛ-ВО ЖИВОТНЫХ КОНКРЕТНОГО ВИДА
    // НА СЕБЕ
    // МАССИВ?
    public static Animal[] countOfWolfsOnСell = new Animal[Settings.wolfMaxNumber];

    public static void printWolfsOnCell() {
        long count = Arrays.stream(countOfWolfsOnСell).filter(animal -> animal instanceof Wolf).count();
        System.out.println("count -> " + count);
        int freeSpace = (int) (countOfWolfsOnСell.length - count);
        // тут проверить правильность условия
        if ( freeSpace > 0 ) {
            for (int i = 0; i < countOfWolfsOnСell.length; i++) {

            }
        }

    }

    public static void printArray() {
        int j=0;
        for (int i = 1; i <= countOfWolfsOnСell.length; i++) {

            System.out.println("i -> " + i + " value -> " + countOfWolfsOnСell[j++]);

        }
    }
}

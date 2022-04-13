package com.kodilla.patterns.factory.enemies;

public class EnemyFactory {

    public AbstractEnemyUnit makeEnemyUnit(String newEnemyUnit) {

        AbstractEnemyUnit newUnit = null;

        switch (newEnemyUnit) {
            case "s":
                return new SmallEnemyUnit("Ducky", "Small warhead unit!", 10);
            case "m":
                return new MediumEnemyUnit("Cow", "Medium warhead unit full of metan!", 20);
            case "b":
                return new BossEnemyUnit("Wolf", "Boss warhead unit that is powerful big dog!", 50);
            default:
                return null;
        }
    }
}

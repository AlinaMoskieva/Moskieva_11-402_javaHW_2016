package ru.itis.inform;

/**
 * рыцарь, спасающего даму
 */
public class DamselRescuingKnight implements  Knight {
    private RescueDamselQuest quest;
    public DamselRescuingKnight() {
        quest = new RescueDamselQuest(); // Тесная связь с классом
    } // RescueDamselQuest
    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}

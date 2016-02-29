package ru.itis.inform;

/**
 * Created by Moskieva on 29.02.16.
 */
public interface Quest {
    /**
     * спасти даму
     * @throws QuestException
     */
    void RescueDamselQuest() throws QuestException;

    /**
     * убить дракона
     * @throws QuestException
     */
    void SlayDragonQuest () throws QuestException;

    /**
     * стать рыцарем Круглого стола
     * @throws QuestException
     */
     void MakeRoundTableRounderQuest() throws QuestException;

    /**
     * начинать
     * @throws QuestException
     */
     void embark() throws QuestException;
}

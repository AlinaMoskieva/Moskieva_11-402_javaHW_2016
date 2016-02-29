package ru.itis.inform;

/**
 * Created by Moskieva on 29.02.16.
 */
public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest) {
        this.quest = quest; // Внедрение сценария подвига, внедрение через конструктор.
    }
    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }



}

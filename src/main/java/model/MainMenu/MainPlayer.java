package model.MainMenu;

import services.IMainMenuStrategy;

import lombok.Data;
@Data
public class MainPlayer {
    private IMainMenuStrategy mainMenuStrategy;

    public MainPlayer(IMainMenuStrategy mainMenuStrategy) {
        this.mainMenuStrategy = mainMenuStrategy;
    }

    public void changeOptionMain(IMainMenuStrategy mainMenuStrategy) {
        this.mainMenuStrategy = mainMenuStrategy;
    }

    public void adjustMainEstanciero() {
        System.out.println();
        mainMenuStrategy.adjustMainMenu();
    }
}

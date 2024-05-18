package model.MainMenu;

import services.IMainMenuStrategy;

import lombok.Data;
@Data
public class MainPlayer {
    private IMainMenuStrategy mainMenuStrategy;

    public MainPlayer(IMainMenuStrategy mainMenuStrategy) {
        this.mainMenuStrategy = mainMenuStrategy;
    }

    public void changeOptionMain(IMainMenuStrategy newStrategy) {
        this.mainMenuStrategy = newStrategy;
    }

    public void adjustMainEstanciero() {
        this.mainMenuStrategy.adjustMainMenu();
    }
}
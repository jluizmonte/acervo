package br.com.acervo.util;

import java.io.FileNotFoundException;

import br.com.acervo.view.FirstSplashView;
import br.com.acervo.view.LoginView;
import br.com.acervo.view.SplashView;

public class CarregarSplash {

    public void setSplashTime() throws FileNotFoundException {

        SplashView Splash = new SplashView();
        FirstSplashView firstSplashView = new FirstSplashView();
        firstSplashView.setVisible(false);
        Splash.setVisible(true);
        for (int i = 0; i <= 80; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }

            if (i == 80) {
                LoginView loginView = new LoginView();
                Splash.setVisible(false);
                loginView.setVisible(true);
            }
        }
    }

}

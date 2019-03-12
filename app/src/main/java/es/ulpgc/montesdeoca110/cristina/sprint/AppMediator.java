package es.ulpgc.montesdeoca110.cristina.sprint;

import android.app.Application;

public class AppMediator extends Application {

    private ContadorState contadorState;
    @Override
    public void onCreate(){
        super.onCreate();

        contadorState = new ContadorState();
    }
    public ContadorState getContadorState(){
        return contadorState;
    }
    public void setContadorState(ContadorState state){
        this.contadorState = state;
    }
}

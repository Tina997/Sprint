package es.ulpgc.montesdeoca110.cristina.sprint;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

public class ContadorRouter implements ContadorContract.Router {

    public static String TAG = ContadorRouter.class.getSimpleName();

    private AppMediator mediator;

    public ContadorRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToNextScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ContadorActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToNextScreen(ContadorState state) {
        mediator.setContadorState(state);
    }

    @Override
    public ContadorState getDataFromPreviousScreen() {
        ContadorState state = mediator.getContadorState();
        return state;
    }
}

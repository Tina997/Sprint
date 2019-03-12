package es.ulpgc.montesdeoca110.cristina.sprint;

import java.lang.ref.WeakReference;

interface ContadorContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayData(ContadorViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void fetchData();

        void updateContador();
    }

    interface Model {
        String fetchData();
    }

    interface Router {
        void navigateToNextScreen();

        void passDataToNextScreen(ContadorState state);

        ContadorState getDataFromPreviousScreen();
    }
}

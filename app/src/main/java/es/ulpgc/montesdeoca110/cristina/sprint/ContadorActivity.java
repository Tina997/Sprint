package es.ulpgc.montesdeoca110.cristina.sprint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContadorActivity
        extends AppCompatActivity implements ContadorContract.View {

    public static String TAG = ContadorActivity.class.getSimpleName();

    private ContadorContract.Presenter presenter;

    Button botonInc;
    TextView textViewContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        getSupportActionBar().setTitle("Contador");

        botonInc = findViewById(R.id.button);
        textViewContador = findViewById(R.id.data);

        botonInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateContador();
            }
        });
        // do the setup
        ContadorScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // do some work
        presenter.fetchData();
    }

    @Override
    public void injectPresenter(ContadorContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayData(ContadorViewModel viewModel) {
        //Log.e(TAG, "displayData()");

        // deal with the data
        ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }
}

package iesnervion.rmanzano.masterdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

import iesnervion.rmanzano.masterdetails.clases.Contacto;
import iesnervion.rmanzano.masterdetails.fragments.ContactoFragment;
import iesnervion.rmanzano.masterdetails.fragments.DetalleFragment;
import iesnervion.rmanzano.masterdetails.fragments.InsertarFragment;
import iesnervion.rmanzano.masterdetails.viewModel.ContactoViewModel;

public class MainActivity extends AppCompatActivity {

    private ContactoFragment contactoFragment;
    private DetalleFragment detalleFragment;
    private InsertarFragment insertarFragment;
    private ContactoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactoFragment = new ContactoFragment();
        detalleFragment = new DetalleFragment();
        insertarFragment = new InsertarFragment();


        viewModel = ViewModelProviders.of(this).get(ContactoViewModel.class);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, contactoFragment).addToBackStack(null).commit();

        //Este observador ve los botones pulsados
        viewModel.getSaberBotonPulsado().observe(this, new Observer<Integer>() {

            @Override
            public void onChanged(Integer pulsacion) {
                switch (pulsacion) {
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, detalleFragment).addToBackStack(null).commit();
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, insertarFragment).addToBackStack(null).commit();
                        break;

                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, contactoFragment).addToBackStack(null).commit();
                        break;

                }
            }
        });


    }
}

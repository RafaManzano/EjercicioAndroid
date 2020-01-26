package iesnervion.rmanzano.coincatch.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import iesnervion.rmanzano.coincatch.R;
import iesnervion.rmanzano.coincatch.viewModel.CoinViewModel;
import iesnervion.rmanzano.coincatch.viewModel.MainViewModel;

public class FragmentFinalizar extends Fragment implements View.OnClickListener {
    private TextView monedasCapturadas;
    private CoinViewModel coinViewModel;
    private Button repetir;
    private Button terminar;
    private TextView nickname;
    private MainViewModel mainViewModel;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public FragmentFinalizar() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        terminar = v.findViewById(R.id.terminar);
        repetir = v.findViewById(R.id.repetir);
        monedasCapturadas = v.findViewById(R.id.mostrarMonedas);
        nickname = v.findViewById(R.id.nickname);
        nickname.setText(mainViewModel.getNickname());
        //coinViewModel = new CoinViewModel(); Esto no puede ser porque sino habria dos instancias
        //ViewModel
        coinViewModel = ViewModelProviders.of(getActivity()).get(CoinViewModel.class);

        if(coinViewModel.getMonedas() < 0) {
            coinViewModel.setMonedas(0);
            monedasCapturadas.setText(monedasCapturadas.getText() + " " + coinViewModel.getMonedas());
        }
        else {
            monedasCapturadas.setText(monedasCapturadas.getText() + " " + coinViewModel.getMonedas());
        }

        //onclick
        terminar.setOnClickListener(this);
        repetir.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.repetir:
                //Mandamos la pulsacion del boton a la actividad
                coinViewModel.setBotonPulsado(1);
                break;

            case R.id.terminar:
                //Mandamos la pulsacion del boton a la actividad
                coinViewModel.setBotonPulsado(2);
                break;
        }
        insertarPuntuacion();

    }

    public void recogerNick() {
        if(nickname.getText().toString().equals("")) {
            nickname.setText(R.string.anonimo);
        }
        else {
            nickname.getText().toString();
        }
    }

    public void insertarPuntuacion() {
        Map<String, Object> data = new HashMap<>();
        recogerNick();
        data.put("Nickname", nickname.getText().toString());
        data.put("Score", coinViewModel.getMonedas());

        if(coinViewModel.getMonedas() > 0) {
            db.collection("Stats")
                    .add(data)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("CORRECTO", "DocumentSnapshot written with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w("INCORRECTO", "Error adding document", e);
                        }
                    });
        }




    }

}

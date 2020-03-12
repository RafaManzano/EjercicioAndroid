package iesnervion.rmanzano.coincatchdef.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import iesnervion.rmanzano.coincatchdef.R;
import iesnervion.rmanzano.coincatchdef.viewModel.MainViewModel;

public class FinishFragment extends Fragment implements View.OnClickListener {
    private TextView monedasCapturadas; //El texto de las monedas capturadas
    private Button repetir; //Boton repetir juego
    private Button terminar; //Boton terminar juego
    private TextView nickname; //El texto para el nombre
    private MainViewModel mainViewModel; //Para instanciar el viewModel
    private MediaPlayer soundplayer; //Para los sonidos

    //SharedPreferences
    SharedPreferences shared;

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.finish_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        //La instancia del viewModel
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        //SharedPreferences
        shared = getActivity().getSharedPreferences("shared", Context.MODE_PRIVATE);

        terminar = v.findViewById(R.id.terminar);
        repetir = v.findViewById(R.id.repetir);
        monedasCapturadas = v.findViewById(R.id.mostrarMonedas);
        nickname = v.findViewById(R.id.nickname);
        recogerNick();

        //Introducimos los datos necesarios en su texto
        nickname.setText(mainViewModel.getNickname());
        monedasCapturadas.setText(monedasCapturadas.getText() + " " + mainViewModel.getMonedas());

        //Con esto dependiendo de las monedas que tiene elegimos un sonido u otro
        if(mainViewModel.getMonedas() <= 0) {
            soundplayer = MediaPlayer.create(getActivity(), R.raw.ceromonedas);
            empezarSonido();
        }
        else {
            soundplayer = MediaPlayer.create(getActivity(), R.raw.masmonedas);
            empezarSonido();
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
                mainViewModel.setBotonPulsado(7);
                break;

            case R.id.terminar:
                //Mandamos la pulsacion del boton a la actividad
                mainViewModel.setBotonPulsado(8);
                break;
        }
        insertarPuntuacion();
        mainViewModel.setMonedas(0); //Con esto decidimos que cuando se vuelva hacia la partida o hacia el menu
        //principal, las monedas vuelven a 0

    }

    /*
    Con este metodo en el caso de que el nombre se quede vacio, ponemos anonimo para poder registrarlo en la BBDD con un
    nombre
     */
    public void recogerNick() {
        if(nickname.getText().toString().equals("")) {
            nickname.setText(R.string.anonimo);
        }
        else {
            nickname.getText().toString();
        }
    }

    /*
    Para introducir la puntuacion en la BBDD
     */
    public void insertarPuntuacion() {
        Map<String, Object> data = new HashMap<>();
        recogerNick();
        data.put("Nickname", nickname.getText().toString());
        data.put("Score", mainViewModel.getMonedas());
        data.put("Level", mainViewModel.getLevel());

        if(mainViewModel.getMonedas() > 0) { //En el caso de que sea 0 no se introducira
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

    public void empezarSonido() {
        if(shared.getBoolean("Efecto", true)) {
            soundplayer.start();
        }
    }

}

package iesnervion.rmanzano.coincatchdef.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class InfoDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Hola cadete, la mision es la siguiente. Necesitamos la mayor cantidad de monedas posibles, en todo momento puedes plantarte y recoger todas las monedas, pero cuidado, los meteoritos y los agujeros negros estan para hacer mas dificil tu mision. Si encuentras la nave duplicaras tus ganacias. La luna esta de esspectadora. Buena suerte muchach@")
                .setPositiveButton("Comprendo la mision", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}

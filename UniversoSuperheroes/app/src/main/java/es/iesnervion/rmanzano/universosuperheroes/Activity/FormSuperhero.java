package es.iesnervion.rmanzano.universosuperheroes.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import es.iesnervion.rmanzano.universosuperheroes.Clases.Personaje;
import es.iesnervion.rmanzano.universosuperheroes.R;

public class FormSuperhero extends AppCompatActivity {
    private static final int GALLERY_REQUEST_CODE = 1;
    private String[] companhias = new String[2];
    private EditText et;
    private int foto;
    private Personaje p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        companhias[0] = "DC";
        companhias[1] = "Marvel";
        setContentView(R.layout.activity_form_superhero);
        Spinner spin = findViewById(R.id.spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,companhias);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }

    public void elegirFoto(View view) {
        //Create an Intent with action as ACTION_PICK
        Intent intent=new Intent(Intent.ACTION_PICK);
        // Sets the type as image/*. This ensures only components of type image are selected
        intent.setType("image/*");
        //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        // Launching the Intent 
        startActivityForResult(intent,GALLERY_REQUEST_CODE);

    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode){
                case GALLERY_REQUEST_CODE:
                    Toast.makeText(this, "Lo siento, de momento foto por defecto", Toast.LENGTH_LONG);
                    //data.getData returns the content URI for the selected Image
                    Uri selectedImage = data.getData();
                    //imageView.setImageURI(selectedImage);
                    foto = R.drawable.defecto;
                    break;
            }
    }

    public void enviar(View view) {
        p = new Personaje();

    }

}

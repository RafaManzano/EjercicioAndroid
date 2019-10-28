package iesnervion.rmanzano.camaraygaleria;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends Activity {
    /**
     * Constantes para identificar la accion realizada (tomar una fotografia
     * o bien seleccionarla de la galeria)
     */
    private static int TAKE_PICTURE = 1;
    private static int SELECT_PICTURE = 2;

    /**
     * Variable que define el nombre para el archivo donde escribiremos
     * la fotografia de tamanho completo al tomarla.
     */
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = Environment.getExternalStorageDirectory() + "/test.jpg";

        Button btnAction = findViewById(R.id.btnPic);
        btnAction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Obtenemos los botones de imagen completa y de galeria para revisar su estatus
                 * mas adelante
                 */
                RadioButton rbtnFull = findViewById(R.id.radbtnFull);
                RadioButton rbtnGallery = findViewById(R.id.radbtnGall);

                /**
                 * Para todos los casos es necesario un intent, si accedemos la camara con la accion
                 * ACTION_IMAGE_CAPTURE, si accedemos la galeria con la accion ACTION_PICK.
                 * En el caso de la vista previa (thumbnail) no se necesita mas que el intent,
                 * el codigo e iniciar la actividad. Por eso inicializamos las variables intent y
                 * code con los valores necesarios para el caso del thumbnail, asi si ese es el
                 * boton seleccionado no validamos nada en un if.
                 */
                Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                int code = TAKE_PICTURE;

                /**
                 * Si la opcion seleccionada es fotografia completa, necesitamos un archivo donde
                 * guardarla
                 */
                if (rbtnFull.isChecked()) {
                    Uri output = Uri.fromFile(new File(name));
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                    /**
                     * Si la opcion seleccionada es ir a la galeria, el intent es diferente y el codigo
                     * tambien, en la consecuencia de que esta chequeado el boton de la galeria se hacen
                     * esas asignaciones
                     */
                } else if (rbtnGallery.isChecked()){
                    intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    code = SELECT_PICTURE;
                }

                /**
                 * Luego, con todo preparado iniciamos la actividad correspondiente.
                 */
                startActivityForResult(intent, code);
            }
        });
    }

    /**
     * Funcion que se ejecuta cuando concluye el intent en el que se solicita una imagen
     * ya sea de la camara o de la galeria
     */
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * Se revisa si la imagen viene de la camara (TAKE_PICTURE) o de la galeria (SELECT_PICTURE)
         */
        if (requestCode == TAKE_PICTURE) {
            /**
             * Si se reciben datos en el intent tenemos una vista previa (thumbnail)
             */
            if (data != null) {
                /**
                 * En el caso de una vista previa, obtenemos el extra "data" del intent y
                 * lo mostramos en el ImageView
                 */
                if (data.hasExtra("data")) {
                    ImageView iv = findViewById(R.id.imgView);
                    iv.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
                }
                /**
                 * De lo contrario es una imagen completa
                 */
            } else {
                /**
                 * A partir del nombre del archivo ya definido lo buscamos y creamos el bitmap
                 * para el ImageView
                 */
                ImageView iv = findViewById(R.id.imgView);
                iv.setImageBitmap(BitmapFactory.decodeFile(name));
                /**
                 * Para guardar la imagen en la galeria, utilizamos una conexion a un MediaScanner
                 */
                new MediaScannerConnectionClient() {
                    private MediaScannerConnection msc = null; {
                        msc = new MediaScannerConnection(getApplicationContext(), this); msc.connect();
                    }
                    public void onMediaScannerConnected() {
                        msc.scanFile(name, null);
                    }
                    public void onScanCompleted(String path, Uri uri) {
                        msc.disconnect();
                    }
                };
            }
            /**
             * Recibimos el URI de la imagen y construimos un Bitmap a partir de un stream de Bytes
             */
        } else if (requestCode == SELECT_PICTURE){
            Uri selectedImage = data.getData();
            InputStream is;
            try {
                is = getContentResolver().openInputStream(selectedImage);
                BufferedInputStream bis = new BufferedInputStream(is);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                ImageView iv = findViewById(R.id.imgView);
                iv.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {}
        }
    }
}



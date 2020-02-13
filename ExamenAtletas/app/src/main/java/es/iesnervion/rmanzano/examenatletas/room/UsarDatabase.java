package es.iesnervion.rmanzano.examenatletas.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.iesnervion.rmanzano.examenatletas.clases.Atleta;

@Database(entities = {Atleta.class}, version = 1)
public abstract class UsarDatabase extends RoomDatabase {
    private static UsarDatabase INSTANCE;

    public abstract MiDao dao();

    public static UsarDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (UsarDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsarDatabase.class, "atletasDB").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

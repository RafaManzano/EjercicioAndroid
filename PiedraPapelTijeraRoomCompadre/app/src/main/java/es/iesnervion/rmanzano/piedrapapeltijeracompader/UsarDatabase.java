package es.iesnervion.rmanzano.piedrapapeltijeracompader;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Estadistica.class}, version = 1)
public abstract class UsarDatabase extends RoomDatabase  {
    private static UsarDatabase INSTANCE;

    public abstract MiDao dao();

    static UsarDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (UsarDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UsarDatabase.class, "estadisticasDB").allowMainThreadQueries()
                        .build();
                }
            }
        }
        return INSTANCE;
    }
}

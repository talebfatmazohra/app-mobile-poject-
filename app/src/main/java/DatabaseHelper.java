import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gestionVaccins.db";
    private static final int DATABASE_VERSION = 1;
    // Table users
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_EMAIL = "email";
    // Table enfants
    public static final String TABLE_ENFANTS = "enfants";
    public static final String COLUMN_ENFANT_ID = "id";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_DATE_NAISSANCE = "date_naissance";
    public static final String COLUMN_PHOTO = "photo";
    public static final String COLUMN_USER_ID_FK = "user_id";
    // Table vaccins
    public static final String TABLE_VACCINS = "vaccins";
    public static final String COLUMN_VACCIN_ID = "id";
    public static final String COLUMN_VACCIN_NOM = "nom";
    public static final String COLUMN_DESCRIPTION = "description";
    // Table vaccinations
    public static final String TABLE_VACCINATIONS = "vaccinations";
    public static final String COLUMN_VACCINATION_ID = "id";
    public static final String COLUMN_ENFANT_ID_FK = "enfant_id";
    public static final String COLUMN_VACCIN_ID_FK = "vaccin_id";
    public static final String COLUMN_DATE_VACCIN = "date_vaccin";
    public static final String COLUMN_EFFECTUE = "effectue";
    // SQL pour créer la table users
    private static final String TABLE_CREATE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT UNIQUE, " +
                    COLUMN_PASSWORD + " TEXT, " +
                    COLUMN_EMAIL + " TEXT UNIQUE);";
    // SQL pour créer la table enfants
    private static final String TABLE_CREATE_ENFANTS =
            "CREATE TABLE " + TABLE_ENFANTS + " (" +
                    COLUMN_ENFANT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOM + " TEXT, " +
                    COLUMN_DATE_NAISSANCE + " TEXT, " +
                    COLUMN_PHOTO + " BLOB, " +
                    COLUMN_USER_ID_FK + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USERS + "(" +
                    COLUMN_USER_ID + "));";
    // SQL pour créer la table vaccins
    private static final String TABLE_CREATE_VACCINS =
            "CREATE TABLE " + TABLE_VACCINS + " (" +
                    COLUMN_VACCIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_VACCIN_NOM + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT);";
    // SQL pour créer la table vaccinations
    private static final String TABLE_CREATE_VACCINATIONS =
            "CREATE TABLE " + TABLE_VACCINATIONS + " (" +
                    COLUMN_VACCINATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ENFANT_ID_FK + " INTEGER, " +
                    COLUMN_VACCIN_ID_FK + " INTEGER, " +
                    COLUMN_DATE_VACCIN + " TEXT, " +
                    COLUMN_EFFECTUE + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_ENFANT_ID_FK + ") REFERENCES " + TABLE_ENFANTS +
                    "(" + COLUMN_ENFANT_ID + "), " +
                    "FOREIGN KEY(" + COLUMN_VACCIN_ID_FK + ") REFERENCES " + TABLE_VACCINS +
                    "(" + COLUMN_VACCIN_ID + "));";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //créer et mettre à jour la base de données SQLiteaaaaaaaaaaaaaaaaaaaaa
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USERS);
        db.execSQL(TABLE_CREATE_ENFANTS);
        db.execSQL(TABLE_CREATE_VACCINS);
        db.execSQL(TABLE_CREATE_VACCINATIONS);
    }
    // appelée lors d'une mise à jour de la base de données. Elle supprime les tables existantes et les recrée avec les nouvelles versions.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENFANTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VACCINS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VACCINATIONS);
        onCreate(db);
    }
}

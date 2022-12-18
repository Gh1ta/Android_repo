package aseds.ine2.contentprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAjouterNoteInptiste(View view) {
        ContentValues values = new ContentValues();
        values.put(InptisteProvider.NOM, ((EditText) findViewById(R.id.nom)).getText().toString());
        values.put(InptisteProvider.FILIERE, ((EditText) findViewById(R.id.prenom)).getText().toString());
        values.put(InptisteProvider.NOTE, ((EditText) findViewById(R.id.note)).getText().toString());
        Uri uri = getContentResolver().insert(InptisteProvider.CONTENT_URI, values);
        assert uri != null;
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("Range")
    public void onClickRetrouverNotesInptistes(View view) {
        // Retrouver les notes des etudiants
        String URL = "content://aseds.ine2.contentprovidertest.InptisteProvider";
        Uri inptistes = Uri.parse(URL);
        Cursor c;
        c = getContentResolver().query(inptistes, null, null, null, "nom");
        assert c != null;
        if (c.moveToFirst()) {
            do Toast.makeText(this,
                    c.getString(c.getColumnIndex(InptisteProvider._ID)) +
                            "; " + c.getString(c.getColumnIndex(InptisteProvider.NOM)) +
                            "; " + c.getString(c.getColumnIndex(InptisteProvider.FILIERE)) +
                            "; " + c.getString(c.getColumnIndex(InptisteProvider.NOTE)),
                    Toast.LENGTH_SHORT).show(); while (c.moveToNext());
            c.close();
        }
        else{
                Toast.makeText(this,"note not found",Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressLint("Range")
    public void onClickfindNoteByName(View view) {
        String URL = "content://aseds.ine2.contentprovidertest.InptisteProvider";
        Uri inptistes = Uri.parse(URL);
        Cursor c;
        String nom = ((EditText)findViewById(R.id.nom)).getText().toString();
        c = getContentResolver().query(inptistes, null, "nom = ?", new String[]{nom}, "nom");
        assert c != null;
        if (c.moveToFirst()) {
            Toast.makeText(this,
                    c.getString(c.getColumnIndex(InptisteProvider._ID)) +
                            "; " + c.getString(c.getColumnIndex(InptisteProvider.NOM)) +
                            "; " + c.getString(c.getColumnIndex(InptisteProvider.NOTE)),
                    Toast.LENGTH_SHORT).show();
            c.close();
        }
        else{
            Toast.makeText(this,"student not found",Toast.LENGTH_SHORT).show();
        }
    }

}
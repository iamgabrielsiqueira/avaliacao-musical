package br.edu.utfpr.avaliacaomusical;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.utfpr.avaliacaomusical.classes.Album;

public class CadastroAlbumActivity extends AppCompatActivity {
    private EditText editTextAlbum, editTextDate, editTextArtista;

    private RatingBar ratingBarAlbum;

    public static final String NOME_ALBUM = "NOME_ALBUM";
    public static final String DATA_LANCAMENTO = "DATA_LANCAMENTO";
    public static final String ARTISTA = "ARTISTA";
    public static final String CLASSIFICACAO = "CLASSIFICACAO";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextAlbum = findViewById(R.id.editTextAlbum);
        editTextDate = findViewById(R.id.editTextDate);
        editTextArtista = findViewById(R.id.editTextArtista);
        ratingBarAlbum = findViewById(R.id.ratingBarAlbum2);

        setTitle("Adicionar album");
    }

    public static void novoAlbum(AppCompatActivity activity,
                                  @NonNull ActivityResultLauncher<Intent> launcher) {
        Intent intent = new Intent(activity, CadastroAlbumActivity.class);

        launcher.launch(intent);
    }

    public void salvar(View view) {
        String nomeAlbum = editTextAlbum.getText().toString();
        String dataLancamento = editTextDate.getText().toString();
        String artista = editTextArtista.getText().toString();

        int classificacao = (int) ratingBarAlbum.getRating();

        if (nomeAlbum.isEmpty() || dataLancamento.isEmpty() || artista.isEmpty()) {
            Toast.makeText(this,
                    R.string.preencha_todos_os_campos,
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Intent intent = new Intent();

            intent.putExtra(NOME_ALBUM, nomeAlbum);
            intent.putExtra(DATA_LANCAMENTO, dataLancamento);
            intent.putExtra(ARTISTA, artista);
            intent.putExtra(CLASSIFICACAO, classificacao);

            setResult(CadastroAlbumActivity.RESULT_OK, intent);

            finish();
        }
    }
}
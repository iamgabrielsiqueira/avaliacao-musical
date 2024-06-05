package br.edu.utfpr.avaliacaomusical;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.avaliacaomusical.adapter.AlbumAdapter;
import br.edu.utfpr.avaliacaomusical.classes.Album;

public class AlbumActivity extends AppCompatActivity {

    private ListView listViewAlbuns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewAlbuns = findViewById(R.id.listViewAlbuns);

        listViewAlbuns.setOnItemClickListener((parent, view, position, id) -> {
            Album album = (Album) listViewAlbuns.getItemAtPosition(position);

            String msg = getString(R.string.o_album) +
                    album.getNome() +
                    getString(R.string.foi_selecionado);

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        });

        populaLista();
    }

    private void populaLista() {
        /*String[] nomesAlbuns = getResources().getStringArray(R.array.albuns);
        String[] datasAlbuns = getResources().getStringArray(R.array.datas_lancamentos);
        String[] artistasAlbuns = getResources().getStringArray(R.array.artistas);
        int[] classificacoesAlbuns = getResources().getIntArray(R.array.classificacoes);*/

        List<Album> albuns = new ArrayList<>();

        /*for (int i = 0; i < nomesAlbuns.length; i++) {
            String nome = nomesAlbuns[i];
            String dataLancamento = datasAlbuns[i];
            String artista = artistasAlbuns[i];
            int classificacao = classificacoesAlbuns[i];

            Album album = new Album(nome, dataLancamento, artista, classificacao);

            albuns.add(album);
        }*/

        AlbumAdapter adapter = new AlbumAdapter(this, albuns);

        listViewAlbuns.setAdapter(adapter);
    }

    public void abrirTelaSobre(View view) {
        SobreActivity.mostrarTelaSobre(this);
    }
}
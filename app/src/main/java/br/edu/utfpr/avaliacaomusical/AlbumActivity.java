package br.edu.utfpr.avaliacaomusical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
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

    private List<Album> albuns;

    private AlbumAdapter adapter;

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

        setTitle("Avaliação Musical");
    }

    private void populaLista() {
        /*String[] nomesAlbuns = getResources().getStringArray(R.array.albuns);
        String[] datasAlbuns = getResources().getStringArray(R.array.datas_lancamentos);
        String[] artistasAlbuns = getResources().getStringArray(R.array.artistas);
        int[] classificacoesAlbuns = getResources().getIntArray(R.array.classificacoes);*/

        albuns = new ArrayList<>();

        /*for (int i = 0; i < nomesAlbuns.length; i++) {
            String nome = nomesAlbuns[i];
            String dataLancamento = datasAlbuns[i];
            String artista = artistasAlbuns[i];
            int classificacao = classificacoesAlbuns[i];

            Album album = new Album(nome, dataLancamento, artista, classificacao);

            albuns.add(album);
        }*/

        adapter = new AlbumAdapter(this, albuns);

        listViewAlbuns.setAdapter(adapter);
    }

    /*public void abrirTelaSobre(View view) {
        SobreActivity.mostrarTelaSobre(this);
    }*/

    ActivityResultLauncher<Intent> launcherNovoAlbum = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            o -> {
                if (o.getResultCode() == Activity.RESULT_OK) {
                    Intent intent = o.getData();

                    if (intent != null) {
                        Bundle bundle = intent.getExtras();

                        if (bundle != null) {
                            String nomeAlbum = bundle.getString(CadastroAlbumActivity.NOME_ALBUM);
                            String dataLancamento = bundle.getString(CadastroAlbumActivity.DATA_LANCAMENTO);
                            String artista = bundle.getString(CadastroAlbumActivity.ARTISTA);
                            int classificacao = bundle.getInt(CadastroAlbumActivity.CLASSIFICACAO);

                            Album album = new Album(nomeAlbum, dataLancamento, artista, classificacao);

                            albuns.add(album);

                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
    );

    /*public void abrirTelaCadastro(View view) {
        CadastroAlbumActivity.novoAlbum(this, launcherNovoAlbum);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idMenuItem = item.getItemId();

        if (idMenuItem == R.id.menuItemAdicionar) {
            CadastroAlbumActivity.novoAlbum(this, launcherNovoAlbum);
        } else if (idMenuItem == R.id.menuItemSobre) {
            SobreActivity.mostrarTelaSobre(this);
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
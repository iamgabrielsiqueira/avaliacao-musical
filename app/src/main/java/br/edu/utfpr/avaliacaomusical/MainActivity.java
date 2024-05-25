package br.edu.utfpr.avaliacaomusical;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;

    private RadioButton radioButtonSolo, radioButtonBanda;

    private CheckBox checkBoxRock, checkBoxPop, checkBoxMusicaClassica, checkBoxEletronica,
            checkBoxJazz;

    private Spinner spinnerPaisOrigem;

    private RadioGroup radioGroupTipoArtista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNome = findViewById(R.id.plainTextNome);

        radioButtonSolo = findViewById(R.id.radioButtonSolo);
        radioButtonBanda = findViewById(R.id.radioButtonBanda);

        checkBoxRock = findViewById(R.id.checkBoxRock);
        checkBoxPop = findViewById(R.id.checkBoxPop);
        checkBoxMusicaClassica = findViewById(R.id.checkBoxMusicaClassica);
        checkBoxEletronica = findViewById(R.id.checkBoxEletronica);
        checkBoxJazz = findViewById(R.id.checkBoxJazz);

        spinnerPaisOrigem = findViewById(R.id.spinnerPaisOrigem);

        radioGroupTipoArtista = findViewById(R.id.radioGroupTipoArtista);

        this.populaSpinner();
    }

    public void limparCampos(View view) {
        editTextNome.setText("");

        radioButtonSolo.setChecked(false);
        radioButtonBanda.setChecked(false);

        checkBoxRock.setChecked(false);
        checkBoxPop.setChecked(false);
        checkBoxMusicaClassica.setChecked(false);
        checkBoxEletronica.setChecked(false);
        checkBoxJazz.setChecked(false);

        spinnerPaisOrigem.setSelection(0);

        Toast.makeText(this, R.string.campos_limpos, Toast.LENGTH_LONG).show();
    }

    private void populaSpinner() {
        List<String> paises = new ArrayList<>();

        paises.add(getString(R.string.brasil));
        paises.add(getString(R.string.argentina));
        paises.add(getString(R.string.estados_unidos));
        paises.add(getString(R.string.espanha));
        paises.add(getString(R.string.suecia));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                paises
        );

        spinnerPaisOrigem.setAdapter(adapter);
    }

    public void salvar(View view) {
        String nome = editTextNome.getText().toString();

        if (nome.isEmpty()) {
            Toast.makeText(this, R.string.preencha_o_campo_nome, Toast.LENGTH_LONG).show();

            editTextNome.setFocusable(true);
        } else {
            int tipoArtistaSelecionado = radioGroupTipoArtista.getCheckedRadioButtonId();

            String tipoArtista = "";

            if (tipoArtistaSelecionado == R.id.radioButtonSolo) {
                tipoArtista = "Solo";
            } else if (tipoArtistaSelecionado == R.id.radioButtonBanda) {
                tipoArtista = "Banda";
            }

            if (tipoArtista.isEmpty()) {
                Toast.makeText(
                        this,
                        R.string.selecione_um_tipo_de_artista,
                        Toast.LENGTH_LONG
                ).show();

                radioButtonSolo.setFocusable(true);
            } else {
                boolean generoRockChecked = checkBoxRock.isChecked();
                boolean generoPopChecked = checkBoxPop.isChecked();
                boolean generoMusicaClassicaChecked = checkBoxMusicaClassica.isChecked();
                boolean generoEletronicaChecked = checkBoxEletronica.isChecked();
                boolean generoJazzChecked = checkBoxJazz.isChecked();

                if (!generoRockChecked && !generoPopChecked && !generoMusicaClassicaChecked
                        && !generoEletronicaChecked && !generoJazzChecked) {
                    Toast.makeText(
                            this,
                            R.string.selecione_pelo_menos_um_genero_musical,
                            Toast.LENGTH_LONG
                    ).show();

                    checkBoxRock.setFocusable(true);
                } else {
                    String pais = (String) spinnerPaisOrigem.getSelectedItem();

                    Toast.makeText(
                            this,
                            R.string.artista_salvo_com_sucesso,
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        }
    }
}
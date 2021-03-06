package bestsolutions.net.consultamais;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

import org.parceler.Parcels;

import bestsolutions.net.consultamais.entidades.AtividadesCrud;

public class CrudPacienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_paciente);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Novo paciente");

        Intent i = getIntent();
        if (i != null) {
            Fragment crudPaciente;
            if (i.getBooleanExtra(AtividadesCrud.CONTEXTO_CRUD, false)) {
                crudPaciente = AlterarPacienteFragment.newInstance();
                toolbar.setTitle("Alterar Paciente");
            } else {
                crudPaciente = NovoPacienteFragment.newInstance();
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, crudPaciente, "Listagem")
                    .commit();
        }
        setSupportActionBar(toolbar);
    }
}

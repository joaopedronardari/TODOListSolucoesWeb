package web.solucoes.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // Objetos dos componentes na tela
    EditText editText;
    Button button;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Capturando views - inicializando objetos
        list = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        // Criando e setando adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);

        // Click Listener do botao
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarefa = editText.getText().toString();
                adapter.add(tarefa);
            }
        });

        // Listener do onLongClick do item da lista para remover
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.remove(adapter.getItem(position));
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TODO
    }
}

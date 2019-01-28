package cam.fructuso.matias.cam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CPPB1Activity extends AppCompatActivity {

    private Button btnSiguiente;
    Spinner spEstado;
    Spinner spMunicipio;
    ArrayList<String> municipiosArray = new ArrayList<>();
    ArrayAdapter<String> adapterMunicipios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppb1);
        btnSiguiente = findViewById(R.id.btnSiguienteCPPB1);
        spEstado = findViewById(R.id.spEstado);
        spMunicipio = findViewById(R.id.spMunicipio);

        final ArrayList<String> estadosArray = getEstados("estados.json");
        ArrayAdapter<String> adapterEstados =new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,estadosArray);
        spEstado.setAdapter(adapterEstados);

        municipiosArray.add("Primero elige un Estado");
        //municipiosArray = getMunicipios("estados.json", 1);
        adapterMunicipios =new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,municipiosArray);
        spMunicipio.setAdapter(adapterMunicipios);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!=0){
                    municipiosArray.clear();
                    municipiosArray = getMunicipios("estados.json", i);
                    adapterMunicipios =new ArrayAdapter<String>(getBaseContext(),R.layout.support_simple_spinner_dropdown_item,municipiosArray);
                    spMunicipio.setAdapter(adapterMunicipios);
                    adapterMunicipios.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CPPB1Activity.this, CPPB2Activity.class);
                startActivity(intent);
            }

        });




    }
    private ArrayList<String> getEstados(String fileName){
        JSONArray jsonArray=null;
        ArrayList<String> estadosList = new ArrayList<>();
        try {
            InputStream is = getResources().getAssets().open(fileName);
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray=new JSONArray(json);
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    estadosList.add(jsonArray.getJSONObject(i).getString("NOM_ESTADO"));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException je){
            je.printStackTrace();
        }
        return estadosList;
    }
    private ArrayList<String> getMunicipios(String fileName, int position){
        JSONArray jsonArray = null;
        JSONArray jsonArrayMunicipios = null;
        ArrayList<String> municipiosList = new ArrayList<>();

        try {
            InputStream is = getResources().getAssets().open(fileName);
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray=new JSONArray(json);
            jsonArrayMunicipios = jsonArray.getJSONObject(position).getJSONArray("MUNICIPIOS");

            if (jsonArrayMunicipios != null) {
                for (int i = 0; i < jsonArrayMunicipios.length(); i++) {
                    municipiosList.add(jsonArrayMunicipios.getJSONObject(i).getString("NOM_MUN"));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException je){
            je.printStackTrace();
        }
        return municipiosList;
    }

}

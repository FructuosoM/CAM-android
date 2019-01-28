package cam.fructuso.matias.cam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CPPB2Activity extends AppCompatActivity {


    private List<String> names;
    private List<Integer> imagenes;

    private RecyclerView mRecyclerView;
    // Puede ser declarado como 'RecyclerView.Adapter' o como nuetra clase adaptador 'MyAdapterAlimentos'
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppb2);

        names = this.getAllNames();
        imagenes = this.getAllNamesImagenes();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this, 3);
        // mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // Implementamos nuestro OnItemClickListener propio, sobreescribiendo el método que nosotros
        // definimos en el adaptador, y recibiendo los parámetros que necesitamos
        mAdapter = new MyAdapterAlimentos(names, imagenes, R.layout.recycler_view_item, new MyAdapterAlimentos.OnItemClickListener() {
            @Override
            public void onItemClick(String name, int position) {
                Toast.makeText(CPPB2Activity.this, name + " - " + position, Toast.LENGTH_SHORT).show();
                //deleteName(position);
            }
        });

        // Lo usamos en caso de que sepamos que el layout no va a cambiar de tamaño, mejorando el performance
        mRecyclerView.setHasFixedSize(true);
        // Añade un efecto por defecto, si le pasamos null lo desactivamos por completo
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // Enlazamos el layout manager y adaptor directamente al recycler view
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Integer> getAllNamesImagenes() {
        return new ArrayList<Integer>() {{
            add(R.drawable.tomateverdel);
            add(R.drawable.zanahorial);
            add(R.drawable.calabacital);
            add(R.drawable.papablancal);
            add(R.drawable.aguacatehassl);
            add(R.drawable.lechugaromanal);
            add(R.drawable.lechugaorejonal);
            add(R.drawable.cebollablancal);
            add(R.drawable.chileserranol);
            add(R.drawable.jitomatesaladettel);
            add(R.drawable.limonsinsemillal);
            add(R.drawable.chicharol);
            add(R.drawable.ejotel);
            add(R.drawable.pepinol);
            add(R.drawable.chilepoblanol);
            add(R.drawable.naranjal);
            add(R.drawable.pinal);
            add(R.drawable.papayal);
            add(R.drawable.platanotabascol);
            add(R.drawable.manzanal);
            add(R.drawable.higadoderesl);
            add(R.drawable.bistecderesl);
            add(R.drawable.retazoderezl);
            add(R.drawable.polloenterol);
            add(R.drawable.pechugadepollol);
            add(R.drawable.piernaconmuslol);
            add(R.drawable.retazodepollomacizapiernal);
            add(R.drawable.pescadosierral);
            add(R.drawable.lentejasl);
            add(R.drawable.frijolbayol);
            add(R.drawable.arrozl);
            add(R.drawable.sopadepastal);
            add(R.drawable.aceitel);
            add(R.drawable.sardinal);
            add(R.drawable.atunenaguaoaceitel);
            add(R.drawable.salrefinadal);
            add(R.drawable.azucarestandarl);
            add(R.drawable.cafel);
            add(R.drawable.lechepasteurizadal);
            add(R.drawable.lecheliconsal);
            add(R.drawable.quesoblancol);
            add(R.drawable.agual);
            add(R.drawable.pandulcel);
            add(R.drawable.bolillol);
            add(R.drawable.tortillademaizl);
            add(R.drawable.jabondetocadorl);
            add(R.drawable.detergenteenpolvol);
            add(R.drawable.nopalesl);
            add(R.drawable.huevol);
            add(R.drawable.papelhigienicol);
        }};
    }


    private List<String> getAllNames() {
        return new ArrayList<String>() {{
            add("Tomate Verde");
            add("Zanahoria");
            add("Calabacita");
            add("Papa Blanca");
            add("Aguacate Hass");
            add("Lechuga Romana");
            add("lechugaorejona");
            add("Cebolla Blanca");
            add("Chile Serrano");
            add("Jitomate Saladette");
            add("Limon sin Semilla");
            add("Chicharo");
            add("Ejote");
            add("Pepino");
            add("Chile Poblano");
            add("Naranja");
            add("Piña");
            add("Papaya");
            add("Platano Tabasco");
            add("Manzana");
            add("Higado de Res");
            add("Bistec de Res");
            add("Retazo de Res");
            add("Pollo Entero");
            add("Pechuga de Pollo");
            add("Pierna con Muslo");
            add("Retazo de Pollo Maciza-Pierna");
            add("Pescado Sierra");
            add("Lentejas");
            add("Frijol Bayo");
            add("Arroz");
            add("Sopa de Pasta");
            add("aceite");
            add("Sardina");
            add("Atun en Agua o aceite");
            add("Sal Refinada");
            add("Azucar Estandar");
            add("Cafe");
            add("Leche Pasteurizada");
            add("Leche Liconsa");
            add("Queso Blanco");
            add("Agua");
            add("pandulce");
            add("Bolillo");
            add("Tortilla de Maiz");
            add("Jabon de Tocador");
            add("Detergente en Polvo");
            add("Nopales");
            add("Huevo");
            add("Papel Higienico");
        }};
    }
}

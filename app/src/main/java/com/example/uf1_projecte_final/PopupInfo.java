package com.example.uf1_projecte_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.util.ArrayList;

public class PopupInfo extends AppCompatActivity {

    //declarem variables
    private ArrayList<String> informacio = new ArrayList();
    private ArrayList<Integer> imatges_inici = new ArrayList();
    Bundle bundle;
    int pos, ample, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        //recuparem valors
        TextView popup = findViewById(R.id.textView13);

        //declarem mida de la pantalla
        DisplayMetrics mida = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mida);
        ample = mida.widthPixels;
        altura = mida.heightPixels;

        //afegim les mides al PopUp
        getWindow().setLayout((int) (ample*0.85), (int) (altura*0.5));

        //fem aixo per poder pasar per parametre la posició a mostrar
        bundle = getIntent().getExtras();
        pos = bundle.getInt("posicio");

        //afegim a la llista els textos
        informacio.add("");
        informacio.add("Aquests carreus donen informació de qui i com s’ha pogut  construir aquest edifici. Els lleons representen la força, el valor i la noblesa i per altra banda veiem l’escut de la ciutat. La gent de la ciutat s’han preocupat per poder-lo construir i hi ha col·laborat en la mesura que a cadascú li era possible.");
        informacio.add("La ciutat de Valls se sap que ja tenia orgue des de fa molts anys. Quan es va construir aquest edifici ja es va tenir present que n’havia de tenir un i l’any 1590 se sap que ja va sonar per primer cop. L’orgue que podeu veure a la fotografia és el resultat de les restauracions que aquell orgue va anar tenint al llarg dels anys.Durant 346 anys hi va haver un orgue sonant en aquesta nau fins que el 21 de juliol de l’any 1936, amb la guerra civil, va ser destruït. Han passat més de 80 anys fins que no s’ha pogut recuperar un orgue per a la ciutat.");
        informacio.add("La recuperació de l’orgue ha estat possible gracies al treball constant durant els últims anys d’una Comissió ciutadana formada per persones que estimen la ciutat i la cultura. Tal com es va fer amb la construcció de l'edifici s'ha demanat la col·laboració econòmica dels ciutadans per poder  dur a terme aquest projecte. Tota aquesta gent que han fet possible la construcció de l’instrument que avui visitem són els Padrins de l'orgue. El disseny de la façana està inspirat en elements característics de la ciutat.");
        informacio.add("L’antic orgue estava situat a la meitat de la nau i suspès dalt d’una balconada tal com podeu veure en les imatges. De vegades els orgues estan situats just damunt la porta d’entrada de l’edifici en la zona de l’anomenat cor. Hi ha diferents tipus d’orgues segons les èpoques, la utilització que se’n feia, els espais on estaven ubicats...");
        informacio.add("L’orgue és un instrument de vent, això vol dir que el so el produeix l’aire quan vibra en passar pels tubs. Aquest instrument tan gran té unes parts visibles, la façana i la consola, i unes parts que estan a l’interior i que són els mecanismes que fan que l’orgue soni. La consola és el centre de comandament de la persona que toca l’instrument.");
        informacio.add("Aquest orgue en l’actualitat consta de 1384 tubs però està preparat per a tenir-ne 2504. Cada tecla té associat, com a mínim,  un tub per a cada un dels registres que es puguin activar.Recordeu que la recuperació i construcció ha estat possible gràcies a les donacions de gent particular, empreses de la ciutat i les administracions.Hi ha dos tipus de tubs segons la manera de produir el so: els de boca o labials i els de llengüeta.  També  la mida, la forma i els materials dels que estan fets els tubs donen una sonoritat diferent segons el que es requereix per a cada un dels registres.");
        informacio.add("A partir d'ara la Ciutat comptarà amb un intrument ubicat en aquest espai tan gran i que està pensat que tingui diferents usos: Concerts, acompanyament a la litúrgia i aprenentatge i estudi de l'instrument.");
        informacio.add("Aquesta cantata ha estat gravada durant l'any 2023.");

        //li passem la posició de la llista i mostra contingut
        popup.setText(informacio.get(pos));
    }
}
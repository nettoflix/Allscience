package sem.allscience.Matematica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import sem.allscience.Manager.Handler;
import sem.allscience.R;


public class MenuActivity extends AppCompatActivity {
    //Intents
    Intent iMatrizDimensionSelector;
    Intent iDeterminantes;
    Intent iSohcahtoa;
    Intent iGCD;
    Intent iBhaskara;
    //Trigonometria
    boolean trigoListVisible;
    TextView enterSohcahtoa;
    TextView showTrigo;
    //AlgebraLinear
    boolean algebraLinearListVisible;
    TextView enterDt;
    TextView enterMatrizMult;
    //Formulas
    boolean formulasListVisible;
    TextView enterBhaskara;
    TextView enterGCD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_math);
        //init intents
        iSohcahtoa = new Intent(this,TrigonometriaActivity.class);
        iDeterminantes = new Intent(this,DeterminanteActivity.class);
        iGCD = new Intent(this,GCDActivity.class);
        iBhaskara =new Intent(this,BhaskaraActivity.class);
        iMatrizDimensionSelector = new Intent(this, MatrixDimensionSelector.class);
        initFormulasViews();
        initTrigoViews();
        initAlgebraLinearViews();


    }

    private void initFormulasViews() {
        enterBhaskara = (TextView)findViewById(R.id.id_enterBhaskara);
        enterGCD = (TextView)findViewById(R.id.id_enterGCD);
        Handler.hideView(enterBhaskara, true);
        Handler.hideView(enterGCD, true);
    }

    private void initAlgebraLinearViews() {
        algebraLinearListVisible = false;
        enterDt = (TextView) findViewById(R.id.id_enter_determinantes);
        enterMatrizMult = (TextView)findViewById(R.id.id_enter_matrizMultiplication);
        Handler.hideView(enterMatrizMult, true);
        Handler.hideView(enterDt, true);
    }

    //initializers
    public void initTrigoViews()
    {
        trigoListVisible = false;
        //showTrigo = (TextView) findViewById(R.id.id_listTrigo);
        enterSohcahtoa = (TextView) findViewById(R.id.id_sohcahtoa);
        Handler.hideView(enterSohcahtoa, true);
    }
    //functions OnClick
    public void onEnterSohcahtoa(View view) {

        startActivity(iSohcahtoa);
    }
    public void enterMatrizMultiplication(View view) {startActivity((iMatrizDimensionSelector));}
    public void enterDeterminantes(View view) {
        startActivity(iDeterminantes);
    }
    public void onEnterBhaskara(View view) {
        startActivity(iBhaskara);
    }
    public void onEnterGCD(View view) {
        startActivity(iGCD);
    }

    //functions

    public void showTrigoList(View view)
    {
        if (trigoListVisible)
        {
            Handler.hideView(enterSohcahtoa,true);
            trigoListVisible = !trigoListVisible;
        }
        else
        {
            Handler.hideView(enterSohcahtoa,false);
            trigoListVisible = !trigoListVisible;
        }

    }
    public void showAlgebraLinearList(View view) {
        if(algebraLinearListVisible)
        {
            Handler.hideView(enterDt, true);
            Handler.hideView(enterMatrizMult, true);
            algebraLinearListVisible = !algebraLinearListVisible;
        }
        else{
            Handler.hideView(enterMatrizMult, false);
            Handler.hideView(enterDt, false);
            algebraLinearListVisible = !algebraLinearListVisible;
        }
    }
    public void showFormulasList(View view) {
        if (formulasListVisible)
        {
            Handler.hideView(enterBhaskara,true);
            Handler.hideView(enterGCD,true);
            formulasListVisible = !formulasListVisible;
        }
        else
        {
            Handler.hideView(enterBhaskara,false);
            Handler.hideView(enterGCD,false);
            formulasListVisible = !formulasListVisible;
        }
    }





}

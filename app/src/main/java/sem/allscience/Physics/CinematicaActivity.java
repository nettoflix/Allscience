package sem.allscience.Physics;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import sem.allscience.Manager.Handler;
import sem.allscience.Manager.MyMath;
import sem.allscience.R;

public class CinematicaActivity extends AppCompatActivity {
    TextView variablesDef;
    boolean isShowingVariableDef = false;
    TextView TV_equation1_answer;
    EditText EQ1_d_Variable;
    EditText EQ1_Vi_Variable;
    EditText EQ1_a_Variable;
    EditText EQ1_t_Variable;
    LinearLayout EQ1_d_Layout;
    LinearLayout EQ1_Vi_Layout;
    LinearLayout EQ1_a_Layout;
    LinearLayout EQ1_t_Layout;
    EditText EQ2_Vf_Variable;
    EditText EQ2_Vi_Variable;
    EditText EQ2_a_Variable;
    EditText EQ2_d_Variable;
    LinearLayout EQ2_Vf_Layout;
    LinearLayout EQ2_Vi_Layout;
    LinearLayout EQ2_a_Layout;
    LinearLayout EQ2_d_Layout;
    TextView TV_equation2_answer;


    enum cVariable  {
            d,Vi,a,t,Vf
    }
    cVariable variableNotFound;
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_cinematica);

        initVariables();
        Handler.hideView(variablesDef, true);
    }
    public void initVariables()
    {
        variablesDef = findViewById(R.id.id_cinematicsVariablesDef);
        EQ1_d_Variable = findViewById(R.id.cinematics_variable_d);
        EQ1_Vi_Variable = findViewById(R.id.cinematics_variable_Vi);
        EQ1_a_Variable = findViewById(R.id.cinematics_variable_a);
        EQ1_t_Variable = findViewById(R.id.cinematics_variable_t);
        EQ1_d_Layout = findViewById(R.id.layout_cinematics_d);
        EQ1_Vi_Layout = findViewById(R.id.layout_cinematics_Vi);
        EQ1_a_Layout = findViewById(R.id.layout_cinematics_a);
        EQ1_t_Layout = findViewById(R.id.layout_cinematics_t);
        TV_equation1_answer = findViewById(R.id.cinematics_equation1_answer);
        Handler.hideView(TV_equation1_answer, true);
        EQ2_Vf_Variable = findViewById(R.id.cinematics_variable_Vf);
        EQ2_Vi_Variable = findViewById(R.id.cinematics_variable_Vi2);
        EQ2_a_Variable = findViewById(R.id.cinematics_variable_a2);
        EQ2_d_Variable = findViewById(R.id.cinematics_variable_d2);
        EQ2_Vf_Layout = findViewById(R.id.layout_cinematics_Vf);
        EQ2_Vi_Layout = findViewById(R.id.layout_cinematics_Vi2);
        EQ2_a_Layout = findViewById(R.id.layout_cinematics_a2);
        EQ2_d_Layout = findViewById(R.id.layout_cinematics_d2);
        TV_equation2_answer = findViewById(R.id.cinematics_equation2_answer);
    }
    public void showDefinitions(View view) {
        if(isShowingVariableDef)
        {
            Handler.hideView(variablesDef, true);
        }
        else
        {
            Handler.hideView(variablesDef, false);
        }
        isShowingVariableDef = !isShowingVariableDef;
    }
    public void calcularDeslocamentoEquation(View view) {
        int notFoundVariables = 0;
        double d_double=0;
        double Vi_double=0;
        double a_double=0;
        double t_double=0;
        if(MyMath.isNumeric(EQ1_d_Variable.getText().toString())) {
           // int d_int = Integer.parseInt(d_Variable.getText().toString());
            d_double = Double.parseDouble(EQ1_d_Variable.getText().toString());
            Log.d("d_double before", String.valueOf(d_double));
        }
        else
        {
            variableNotFound = cVariable.d;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ1_Vi_Variable.getText().toString())) {
            Vi_double = Double.parseDouble(EQ1_Vi_Variable.getText().toString());

        }
        else
        {
            variableNotFound = cVariable.Vi;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ1_a_Variable.getText().toString())) {
            a_double = Double.parseDouble(EQ1_a_Variable.getText().toString());

        }
        else
        {
            variableNotFound = cVariable.a;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ1_t_Variable.getText().toString())) {
            t_double = Double.parseDouble(EQ1_t_Variable.getText().toString());;
        }
        else
        {
            variableNotFound = cVariable.t;
            notFoundVariables++;
        }
        //check if only one variable has not been found, if so, call the method that calculate its correspondent value
        //if there are more than one variable missing, warn the user that the equation can't be solved
        if(notFoundVariables == 1)
        {
        switch(variableNotFound)
        {
            case d:
               double d= EQ1_calcule_d(Vi_double, a_double, t_double);   //parse the data found in the editTexts into double so we can make the calculations
                EQ1_d_Variable.setText(Handler.formartDoubleToString(d));
                EQ1_d_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
              //
                break;
            case Vi:
               double Vi= EQ1_calcule_Vi(d_double, a_double, t_double);
                EQ1_Vi_Variable.setText(Handler.formartDoubleToString(Vi));
                EQ1_Vi_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                break;
            case a:
                double a = EQ1_calcule_a(d_double, Vi_double, t_double);
                EQ1_a_Variable.setText(Handler.formartDoubleToString(a));
                EQ1_a_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                break;
            case t:
                double t = EQ1_calcule_t(d_double,Vi_double, a_double);
                EQ1_t_Variable.setText(Handler.formartDoubleToString(t));
                EQ1_t_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                break;
        }
        TV_equation1_answer.setText("Com uma velocidade inicial de " + EQ1_Vi_Variable.getText().toString() + "m/s " + "e com uma aceleração constante de " +
                EQ1_a_Variable.getText().toString() + " m/s, "+ "no decorrer de " + EQ1_t_Variable.getText().toString() + " segundos, você percorrerá "
                +EQ1_d_Variable.getText().toString() +" metros.");
        Handler.hideView(TV_equation1_answer, false);

        }
        else
        {
            TV_equation1_answer.setText("Há mais de uma incógnita desconhecida, a equação não pode ser resolvida");
            Handler.hideView(TV_equation1_answer, false);
        }
    }
    private double EQ1_calcule_d(double Vi, double a, double t)
    {
      double  d = (Vi * t) + (a * Math.pow(t,2)) /2;
      return d;
    }
    private double EQ1_calcule_Vi(double d, double a, double t)
    {
       double Vi = ((2 * d) - (a*Math.pow(t,2))) / (2*t);
       return Vi;
    }
    private double EQ1_calcule_a(double d, double Vi, double t)
    {
        double a = (2*d - 2*Vi*t)/Math.pow(t,2);
        return a;
    }
    private double EQ1_calcule_t(double d, double Vi, double a)
    {
        double t=0;
        if(a!=0) { //if "a" is ZERO, than this is not a quadratic equation
            MyMath.bhaskara quadraticEquationData = MyMath.solveQuadraticEquation(a / 2, Vi, -d);
            if (quadraticEquationData.x1 >= 0) t = quadraticEquationData.x1;
            if (quadraticEquationData.x2 >= 0) t = quadraticEquationData.x2;
        }
        else // "a" is zero, so just uso the fundamental and more simple equation d = Vi.t
        {
            t = d/Vi;
        }
        return t;
    }
    public void calcularVF2equation(View view) {
        int notFoundVariables = 0;
        double Vf_double=0;
        double Vi_double=0;
        double a_double=0;
        double d_double=0;
        if(MyMath.isNumeric(EQ2_Vf_Variable.getText().toString())) {
            // int d_int = Integer.parseInt(d_Variable.getText().toString());
            Vf_double = Double.parseDouble(EQ2_Vf_Variable.getText().toString());

        }
        else
        {
            variableNotFound = cVariable.Vf;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ2_Vi_Variable.getText().toString())) {
            Vi_double = Double.parseDouble(EQ2_Vi_Variable.getText().toString());

        }
        else
        {
            variableNotFound = cVariable.Vi;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ2_a_Variable.getText().toString())) {
            a_double = Double.parseDouble(EQ2_a_Variable.getText().toString());

        }
        else
        {
            variableNotFound = cVariable.a;
            notFoundVariables++;
        }
        if(MyMath.isNumeric(EQ2_d_Variable.getText().toString())) {
            d_double = Double.parseDouble(EQ2_d_Variable.getText().toString());;
        }
        else
        {
            variableNotFound = cVariable.d;
            notFoundVariables++;
        }
        //check if only one variable has not been found, if so, call the method that calculate its correspondent value
        //if there are more than one variable missing, warn the user that the equation can't be solved
        if(notFoundVariables == 1)
        {
            switch(variableNotFound)
            {
                case Vf:
                    double Vf= EQ2_calcule_Vf(Vi_double, a_double, d_double);   //parse the data found in the editTexts into double so we can make the calculations
                    EQ2_Vf_Variable.setText(Handler.formartDoubleToString(Vf));
                    EQ2_Vf_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                    //
                    break;
                case Vi:
                    double Vi= EQ2_calcule_Vi(Vf_double, a_double, d_double);
                    EQ2_Vi_Variable.setText(Handler.formartDoubleToString(Vi));
                    EQ2_Vi_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                    break;
                case a:
                    double a = EQ2_calcule_a(Vf_double, Vi_double, d_double);
                    EQ2_a_Variable.setText(Handler.formartDoubleToString(a));
                    EQ2_a_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                    break;
                case d:
                    double d = EQ2_calcule_d(Vf_double,Vi_double, a_double);
                    EQ2_d_Variable.setText(Handler.formartDoubleToString(d));
                    EQ2_d_Layout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluerect_border));
                    break;
            }


        }
        else
        {
            TV_equation2_answer.setText("Há mais de uma incógnita desconhecida, a equação não pode ser resolvida");
            Handler.hideView(TV_equation2_answer, false);
        }
    }
public double EQ2_calcule_Vf(double Vi, double a, double d)
{
    double Vf = Math.sqrt(Math.pow(Vi,2)+(2*a*d));
    return Vf;
}
public double EQ2_calcule_Vi(double Vf, double a, double d)
{
    double Vi=0;
    double step1 = Math.pow(Vf,2)-(2*a*d);
    if(step1 < 0) return Vi;
    else
    {
         Vi = Math.sqrt(step1);
    }
    return Vi;
}
public double EQ2_calcule_a(double Vf, double Vi, double d)
{
    double a = (Math.pow(Vf,2) - Math.pow(Vi,2)) / (2*d);
        return a;
}
public double EQ2_calcule_d(double Vf, double Vi, double a)
{
    double d = (Math.pow(Vf, 2) - Math.pow(Vi,2))/(2*a);
    return d;
}
    public void onUserInteraction() {
        super.onUserInteraction();
        //remove the blue borders  of the edit text showing the current result, it "resets" it
        EQ1_d_Layout.setBackgroundResource(0);
        EQ1_Vi_Layout.setBackgroundResource(0);
        EQ1_a_Layout.setBackgroundResource(0);
        EQ1_t_Layout.setBackgroundResource(0);
        EQ2_Vf_Layout.setBackgroundResource(0);
        EQ2_Vi_Layout.setBackgroundResource(0);
        EQ2_a_Layout.setBackgroundResource(0);
        EQ2_d_Layout.setBackgroundResource(0);
        //Handler.hideView(TV_equation1_answer,true);
    }
}

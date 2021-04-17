package sem.allscience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import sem.allscience.Chemistry.ChemistryMenuActivity;
import sem.allscience.Matematica.MenuActivity;
import sem.allscience.Physics.PhysicsMenuActivity;



public class MainActivity extends AppCompatActivity {
Intent iMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void goMath(View view) {
        iMenu = null;
         iMenu= new Intent(this, MenuActivity.class);
        startActivity(iMenu);

    }
    public void goPhysics(View view)
    {
        iMenu = null;
        iMenu = new Intent(this, PhysicsMenuActivity.class);
        startActivity(iMenu);
    }
    public void goChemistry(View view)
    {
        iMenu = null;
        iMenu = new Intent(this, ChemistryMenuActivity.class);
        startActivity(iMenu);

    }
}

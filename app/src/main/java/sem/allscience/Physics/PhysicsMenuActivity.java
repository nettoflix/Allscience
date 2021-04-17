package sem.allscience.Physics;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import sem.allscience.R;

public class PhysicsMenuActivity extends AppCompatActivity {
    //Intents
    Intent iCinematics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_physics);
        iCinematics = new Intent(this, CinematicaActivity.class);
    }
    public void openCinematics(View view) {startActivity(iCinematics);}

}
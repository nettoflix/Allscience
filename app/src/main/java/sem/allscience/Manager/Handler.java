package sem.allscience.Manager;

import android.view.View;

import java.text.DecimalFormat;

public class Handler {
    public static boolean isIntParsable(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public static boolean isDoubleParsable(String input){
        try{
            Double.parseDouble(input);
            return true;
        }catch(Exception e){
            return false;
        }
    }
  public static String formartDoubleToString(Double x) {
     DecimalFormat numberFormat = new DecimalFormat("0.00");
       return numberFormat.format(x);
 }
    public static void hideView(View v, boolean b)
    {
        if(b){
            v.setVisibility(View.GONE);
        }
        else
        {
            v.setVisibility(View.VISIBLE);
        }

    }
}

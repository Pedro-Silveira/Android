package ps.technology.internacionalizacao;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnConfigurar;
    public static String sLinguagem;
    public static String sLinguagem2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfigurar = findViewById(R.id.am_btn_configurar);

        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                sLinguagem = Locale.getDefault().getLanguage();
                startActivityForResult(new Intent(Settings.ACTION_LOCALE_SETTINGS), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        sLinguagem2 = Locale.getDefault().getLanguage();

        if(!sLinguagem.equals(sLinguagem2)){
            Intent it = new Intent(MainActivity.this, Final.class);
            startActivity(it);
            finish();
        }else{
            Toast.makeText(getBaseContext(), getResources().getString(R.string.am_snack), Toast.LENGTH_LONG).show();
        }
    }
}
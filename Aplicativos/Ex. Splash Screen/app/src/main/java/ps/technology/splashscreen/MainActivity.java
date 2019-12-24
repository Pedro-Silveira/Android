package ps.technology.splashscreen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnRetornar;
    ImageView ivMao;
    Animation aFlutuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRetornar = findViewById(R.id.btn_retornar);
        ivMao = findViewById(R.id.iv_mao);
        aFlutuar = AnimationUtils.loadAnimation(this, R.anim.flutuar);

        ivMao.startAnimation(aFlutuar);
        btnRetornar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/Pedro-Silveira");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });
    }
}

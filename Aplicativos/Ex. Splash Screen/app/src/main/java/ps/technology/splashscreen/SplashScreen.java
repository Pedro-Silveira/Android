package ps.technology.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ThreeBounce;

public class SplashScreen extends AppCompatActivity {

    Sprite threeBounce = new ThreeBounce();
    private static int tempoCarregamento = 2000;

    ImageView ivLogo;
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivLogo = findViewById(R.id.iv_logo);
        pbLoading = findViewById(R.id.skv_loading);

        pbLoading.setIndeterminateDrawable(threeBounce);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent it = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        }, tempoCarregamento);
    }
}
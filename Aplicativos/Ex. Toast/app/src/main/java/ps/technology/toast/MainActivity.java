package ps.technology.toast;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager vpSlides;
    LinearLayout llPontos;

    TextView[] tvPontos;

    AdaptadorSlides adaptadorSlides = new AdaptadorSlides(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpSlides = findViewById(R.id.am_vp_slides);
        llPontos = findViewById(R.id.am_ll_pontos);

        vpSlides.setAdapter(adaptadorSlides);
        adicionarPontos(0);

        vpSlides.addOnPageChangeListener(viewListener);
    }

    public void adicionarPontos(int posição){

        tvPontos = new TextView[2];
        llPontos.removeAllViews();

        for(int i = 0; i < tvPontos.length; i++){
            tvPontos[i] = new TextView(this);
            tvPontos[i].setText(Html.fromHtml("&#8226;"));
            tvPontos[i].setTextSize(35);
            tvPontos[i].setTextColor(Color.parseColor("#cccccc"));

            llPontos.addView(tvPontos[i]);
        }

        if(tvPontos.length > 0){
            tvPontos[posição].setTextColor(Color.parseColor("#ffffff"));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            adicionarPontos(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {
        }
    };
}
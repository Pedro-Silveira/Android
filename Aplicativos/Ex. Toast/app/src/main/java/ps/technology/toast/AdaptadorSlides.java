package ps.technology.toast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import es.dmoral.toasty.Toasty;

public class AdaptadorSlides extends PagerAdapter{

    Context contexto;
    LayoutInflater infladorLayout;
    ImageView ivImagem;
    TextView tvTitulo, tvTexto;

    public int flag = 0;
    public int[] imagens = {R.drawable.a, R.drawable.b};
    public int[] titulos = {R.string.a1, R.string.a2};
    public int[] textos = {R.string.b1, R.string.b2};

    public AdaptadorSlides(Context contexto){
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final View container, final int posição) {

        infladorLayout = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
        View view = infladorLayout.inflate(R.layout.layout_slide, (ViewGroup) container, false);

        ivImagem = view.findViewById(R.id.ls_iv_imagem);
        tvTitulo = view.findViewById(R.id.ls_tv_titulo);
        tvTexto = view.findViewById(R.id.ls_tv_texto);

        ivImagem.setImageResource(imagens[posição]);
        tvTitulo.setText(titulos[posição]);
        tvTexto.setText(textos[posição]);

        ivImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posição == 0){
                    Toast.makeText(contexto, R.string.toast1, Toast.LENGTH_SHORT).show();
                }else if(posição == 1){
                    Toasty.info(contexto, R.string.toast2, Toast.LENGTH_LONG, true).show();
                }
                if(flag == 0){
                    if(posição == 0){
                        flag = 1;
                    }else {
                        flag = 2;
                    }
                }else if(flag == 1){
                    if(posição == 1){
                        contexto.startActivity(new Intent(contexto, Final.class));
                        ((Activity)contexto).finish();
                    }
                }else if(flag == 2){
                    if(posição == 0){
                        contexto.startActivity(new Intent(contexto, Final.class));
                        ((Activity)contexto).finish();
                    }
                }
            }
        });

        ((ViewGroup) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
package application.android.example.com.videoview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    int[] imgf={R.drawable.gold,R.drawable.st,R.drawable.img};
    Button pre,nex;
    int count=0;
    ImageView img;
    Animation anim,animf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.img);
        pre=findViewById(R.id.pre);
        nex=findViewById(R.id.nex);
        anim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
        anim.setAnimationListener(this);
        animf= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
        animf.setAnimationListener(this);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             
                if(imgf[0]<count){
                    Toast.makeText(getApplicationContext(),"No previous Image",Toast.LENGTH_SHORT).show();
                }else if(imgf[0]==count){
                    img.setImageResource(R.drawable.img);
                    img.setAnimation(anim);
                }else if(imgf[1]==count){
                    img.setImageResource(R.drawable.st);
                    img.setAnimation(anim);
                }else if(imgf[2]==count){
                    img.setImageResource(R.drawable.gold);
                    img.setAnimation(anim);
                }
            }
        });
        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(imgf[0]>3){
                    Toast.makeText(getApplicationContext(),"No Next Image",Toast.LENGTH_SHORT).show();
                }else if(imgf[0]==count){
                    img.setImageResource(R.drawable.img);
                    img.setAnimation(animf);
                }else if(imgf[1]==count){
                    img.setImageResource(R.drawable.st);
                    img.setAnimation(animf);
                }else if(imgf[2]==count){
                    img.setImageResource(R.drawable.gold);
                    img.setAnimation(animf);
                }
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}

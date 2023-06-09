package com.app.graphicsandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.app.graphicsandroid.databinding.ActivityAnimationsBinding;

public class AnimationsActivity extends AppCompatActivity {

    ActivityAnimationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnimationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FlingAnimation flingAnimation = new FlingAnimation(binding.img, DynamicAnimation.Y);
        flingAnimation.setStartVelocity(2000);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                flingAnimation.setStartVelocity(2000);
//                flingAnimation.setFriction(1.5f);
//                flingAnimation.start();
//                binding.img.setImageResource(R.drawable.ic_android_black_24dp);
                Intent intent = new Intent(AnimationsActivity.this, TransitionActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AnimationsActivity.this,
                        new Pair<>(binding.btn,"btn"),
                        new Pair<>(binding.img,"img")
                        );
                startActivity(intent, options.toBundle());


            }
        });

        flingAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                binding.img.setImageResource(R.drawable.baseline_av_timer_24);
            }
        });

        final SpringAnimation animation = new SpringAnimation(binding.img, DynamicAnimation.TRANSLATION_Y,0f);
        animation.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        animation.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);

        animation.addEndListener((animation1, canceled, value, velocity) -> {
            binding.img.setY(50f);
            animation.animateToFinalPosition(500f);
        });

    }
}
package com.mapa.configurandoabasoficial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mapa.configurandoabasoficial.databinding.ActivityMainBinding;
import com.mapa.configurandoabasoficial.fragment.EmAltaFragment;
import com.mapa.configurandoabasoficial.fragment.HomeFragment;
import com.mapa.configurandoabasoficial.fragment.InscricoesFragment;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //Configurar o Adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)//adiciona as abas (Recebe um title e um Fragment)
                        .add("Inscrições", InscricoesFragment.class)
                        .add("Em Alta", EmAltaFragment.class)
                .create()

        );

        //Configurações do ViewPager
        binding.viewPager.setAdapter(adapter); //eu pego o adapter e atribuo ao viewPager
        binding.viewPagerTab.setViewPager(binding.viewPager); // atribuo o meu adapter que contem as abas para o meu viewPagerTab
    }
}
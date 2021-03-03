package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textViewResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaAPP = opcoes[numero];

        switch (escolhaAPP) {
            case "pedra":
            imageResultado.setImageResource(R.drawable.pedra);

            break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaAPP == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaAPP == "papel" && escolhaUsuario == "pedra") ||
                (escolhaAPP == "pedra" && escolhaUsuario == "tesoura")
        ) {
            textoResultado.setText("Você perdeu! =(");

        } else if (

                (escolhaUsuario == "tesoura" && escolhaAPP == "papel") ||
                (escolhaUsuario == "papel" && escolhaAPP == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaAPP == "tesoura")

        ) {
            textoResultado.setText("Você ganhou! =)");
        } else {
            textoResultado.setText("Empatamos!");
        }
    }
}

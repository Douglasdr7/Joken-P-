package br.com.doug.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opcaoUsuario) {

        ImageView imagemResultado = findViewById(R.id.iv_resultado);
        TextView textoResultado = findViewById(R.id.tv_resultado);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (opcaoApp.equals("tesoura") && Objects.equals(opcaoUsuario, "papel")) ||
                        (opcaoApp.equals("papel") && Objects.equals(opcaoUsuario, "pedra")) ||
                        (opcaoApp.equals("pedra") && Objects.equals(opcaoUsuario, "tesoura"))
        ){
            textoResultado.setText("Você perdeu!");
        }else if (
                (opcaoApp.equals("papel") && Objects.equals(opcaoUsuario, "tesoura")) ||
                (opcaoApp.equals("pedra") && Objects.equals(opcaoUsuario, "papel")) ||
                (opcaoApp.equals("tesoura") && Objects.equals(opcaoUsuario, "pedra"))

        ){
            textoResultado.setText("Você Ganhou!");
        }else{//empate
            textoResultado.setText("Empatou!!");
        }
    }


}
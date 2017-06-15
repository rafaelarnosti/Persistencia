package com.rafaelarnosti.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginSPActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etSenha;
    private CheckBox chkContinuarConectado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sp);

        etUser = (EditText)findViewById(R.id.etUser);
        etSenha = (EditText)findViewById(R.id.etSenha);
        chkContinuarConectado = (CheckBox)findViewById(R.id.chkContinuarConectado);
        ler();
    }

    public void logar(View v){
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        if(chkContinuarConectado.isChecked()){
            e.putString("usuario",etUser.getText().toString());
            e.putString("Senha",etSenha.getText().toString());
            e.putBoolean("manterConectado",chkContinuarConectado.isChecked());
        }
        else{
            e.putString("usuario","");
            e.putString("Senha","");
            e.putBoolean("manterConectado",false);
        }
        e.apply();
    }

    private void ler(){
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        etUser.setText(sp.getString("usuario",null));
        etSenha.setText(sp.getString("Senha",null));
        chkContinuarConectado.setChecked(sp.getBoolean("manterConectado",false));
    }
}

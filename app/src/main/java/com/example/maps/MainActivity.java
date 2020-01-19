package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maps.api.ApiRequest;
import com.example.maps.api.RetroClient;
import com.example.maps.model.ResponseApiModel;
import com.example.maps.model.User;
import com.example.maps.util.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPass;
    private Button btnLogin, btnRegis;
    private ProgressDialog pd;
    private static final String Tag = MainActivity.class.getSimpleName();
    private SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        pd = new ProgressDialog(MainActivity.this);
        pd.setMessage("loading ...");

        sessionManager = new SessionManager(MainActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funLogin();
//                Intent intent = new Intent(MainActivity.this, MapsActivity2.class);
//                startActivity(intent);
            }
        });

    }

    private void funLogin()
    {
        pd.setMessage("Loading ...");
        pd.show();
        ApiRequest apiService = RetroClient.getUrl().create(ApiRequest.class);
        Call<ResponseApiModel> login = apiService.login(etEmail.getText().toString(), etPass.getText().toString());
        login.enqueue(new Callback<ResponseApiModel>() {
            @Override
            public void onResponse(Call<ResponseApiModel> call, Response<ResponseApiModel> response) {
                pd.dismiss();
                Log.d(Tag, "response :" + response.toString());
                ResponseApiModel res = response.body();
                List<User> user = res.getResult();
                if (res.getKode().equals("1")){
                    sessionManager.storeLogin(user.get(0).getId_user(), user.get(0).getNm_user(), user.get(0).getLevel_user());
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("id_user", user.get(0).getId_user());
                    intent.putExtra("nama", user.get(0).getNm_user());
                    intent.putExtra("level", user.get(0).getLevel_user());
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "email or password salah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseApiModel> call, Throwable t) {
                pd.dismiss();
                Log.e(Tag, "error : " + t.getMessage());
            }
        });

    }
}

package com.example.bookmylotnwm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnlogin;
    DBHelper DB;
    int reservationcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.Password);
        btnlogin = (Button) findViewById(R.id.signinbutton);
        DB = new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please fillup all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.new_reservation);
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    public void signin(View v) {
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.Password);
        btnlogin = (Button) findViewById(R.id.signinbutton);
        DB = new DBHelper(this);

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("") || pass.equals(""))
            Toast.makeText(MainActivity.this, "Please fillup all the fields", Toast.LENGTH_SHORT).show();
        else {
            Boolean checkuserpass = DB.checkusernamepassword(user, pass);
            if (checkuserpass == true) {
                Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.new_reservation);
            } else {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void checkout(View v) {
        if (reservationcount > 0) {
            setContentView(R.layout.checkoutsuccessful);
            reservationcount = 0;
        } else if (reservationcount == 0) {
            setContentView(R.layout.checkoutunsuccessful);
        }

    }
    public void signup(View v){
        setContentView(R.layout.new_user_registration);
        EditText username, password, repassword;
        Button signup, signin;
        DBHelper DB;
        username = (EditText) findViewById(R.id.usernamenew);
        password = (EditText) findViewById(R.id.passwordnew);
        repassword = (EditText) findViewById(R.id.repasswordnew);
        signup = (Button) findViewById(R.id.register);
        signin = (Button) findViewById(R.id.backtosignin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                setContentView(R.layout.new_reservation);
                            }else{
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });
    }}
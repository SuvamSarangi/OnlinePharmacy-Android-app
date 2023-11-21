package com.example.onlinepharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.onlinepharmacy.databinding.ActivityMedicineBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Medicine extends AppCompatActivity {

    ActivityMedicineBinding binding;

    String userName,email,medicineName,quantity,age;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMedicineBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = binding.etusername.getText().toString();
                email = binding.etemail.getText().toString();
                medicineName = binding.etMedicineName.getText().toString();
                quantity = binding.etquantity.getText().toString();
                age = binding.editTextNumber.getText().toString();

                if (!userName.isEmpty() && !email.isEmpty() && !medicineName.isEmpty() && !quantity.isEmpty() && !age.isEmpty()){
                    Users users = new Users(userName,email,medicineName,quantity,age);

                    db =FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(userName).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.etusername.setText("");
                            binding.etemail.setText("");
                            binding.etMedicineName.setText("");
                            binding.etquantity.setText("");
                            binding.editTextNumber.setText("");
                        }
                    });
                }
            }
        });
    }
}
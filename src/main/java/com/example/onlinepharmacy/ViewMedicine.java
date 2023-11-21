package com.example.onlinepharmacy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.onlinepharmacy.databinding.ActivityViewMedicineBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewMedicine extends AppCompatActivity {


    ActivityViewMedicineBinding binding;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMedicineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.readdataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.etusername.getText().toString();
                if (!userName.isEmpty()){
                    readData(userName);
                }else {
                    Toast.makeText(ViewMedicine.this, "Plese enter user name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData(String userName) {
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(userName).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){
                        Toast.makeText(ViewMedicine.this, "Successfully fetch data", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String  medicineName = String.valueOf(dataSnapshot.child("medicineName").getValue());
                        String quantity =  String.valueOf(dataSnapshot.child("quantity").getValue());
                        String age =  String.valueOf(dataSnapshot.child("age").getValue());

                        binding.tvFirstName.setText(medicineName);
                        binding.tvLastName.setText(quantity);
                        binding.tvAge.setText(age);


                    }else {
                        Toast.makeText(ViewMedicine.this, "User does not exit", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ViewMedicine.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
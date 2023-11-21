package com.example.onlinepharmacy;

public class Users {

    String userName,email,medicineName,quantity,age;

    public Users() {
    }

    public Users(String userName, String email, String medicineName, String quantity, String age) {
        this.userName = userName;
        this.email = email;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.age = age;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

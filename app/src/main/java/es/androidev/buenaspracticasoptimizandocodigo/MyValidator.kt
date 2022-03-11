package es.androidev.buenaspracticasoptimizandocodigo

import android.util.Patterns

object MyValidator {

     fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

     fun isValidPhone(phone: String): Boolean {
        val pattern = Patterns.PHONE;
        return pattern.matcher(phone).matches();
    }
}
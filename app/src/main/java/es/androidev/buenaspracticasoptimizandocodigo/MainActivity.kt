package es.androidev.buenaspracticasoptimizandocodigo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.util.Patterns
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputEditText
import es.androidev.buenaspracticasoptimizandocodigo.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        observerData()
    }

    private fun observerData(){
        lifecycleScope.launch {
            viewModel.isAddUser.collect {
                it?.let{
                    if(it){
                        Toast.makeText(applicationContext, "User created successfully", Toast.LENGTH_SHORT).show()
                        binding.tvRes.text = "User created"
                    }else{
                        Toast.makeText(applicationContext, "Error to add user", Toast.LENGTH_SHORT).show()
                        binding.tvRes.text = "User NOT created"
                    }
                }
            }
        }
    }

    fun onClickSave(view: View) {
        if (!binding.tiedName.text.toString().equals("") && !binding.tiedLastname.toString().equals("")
            && MyValidator.isValidPhone(binding.tiedPhone.text.toString()) && MyValidator.isValidEmail(binding.tiedEmail.text.toString())){
           val user = User(
               binding.tiedName.text.toString(),
               binding.tiedLastname.text.toString(),
               binding.tiedEmail.text.toString(),
               binding.tiedPhone.text.toString()
           )
           viewModel.addUser(user)
        }else{
            Toast.makeText(applicationContext, "You must fill in all the fields", Toast.LENGTH_SHORT).show()
        }

    }

    fun onClickCleanForm(view: View) {
        binding.tiedName.setText("")
        binding.tiedLastname.setText("")
        binding.tiedEmail.setText("")
        binding.tiedPhone.setText("")
    }


}
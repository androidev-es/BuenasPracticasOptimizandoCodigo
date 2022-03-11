package es.androidev.buenaspracticasoptimizandocodigo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {

    private val _isAddUser: MutableStateFlow<Boolean?> =
        MutableStateFlow(null)
    val isAddUser: StateFlow<Boolean?>
        get() = _isAddUser

    fun addUser(user: User) {
        _isAddUser.value = FakeRepository.addUser(user)
    }

}
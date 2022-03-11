package es.androidev.buenaspracticasoptimizandocodigo

object FakeRepository: IRepository {

     override fun addUser(user: User): Boolean{
        //Fake response returned true why insert user is successful
        return true
    }

}
interface IRepository {
    fun addUser(user:User): Boolean
}
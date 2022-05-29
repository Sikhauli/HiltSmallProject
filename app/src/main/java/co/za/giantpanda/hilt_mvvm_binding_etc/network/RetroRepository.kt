package co.za.giantpanda.hilt_mvvm_binding_etc.network

import androidx.lifecycle.LiveData
import co.za.giantpanda.hilt_mvvm_binding_etc.db.AppDao
import co.za.giantpanda.hilt_mvvm_binding_etc.db.RepositoriesData
import co.za.giantpanda.hilt_mvvm_binding_etc.db.RepositoriesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(
  private val retroServiceInterface: RetroServiceInterface,
  private val appDao: AppDao
) {

  fun getAllRecords(): LiveData<List<RepositoriesData>> {
    return appDao.getAllRecords()
  }

  fun insertRecords(repositoriesData: RepositoriesData) {
    appDao.insertItems(repositoriesData)
  }

  //Get data from API
  fun makeApiCall(query: String?) {
    val call: Call<RepositoriesList> = retroServiceInterface.getDataFromApi(query!!)
    call.enqueue(object : Callback<RepositoriesList> {

      override fun onFailure(call: Call<RepositoriesList>, t: Throwable) {
//        Toast.makeText(this, "Failed to load API", Toast.LENGTH_LONG).show()
      }

      override fun onResponse(call: Call<RepositoriesList>, response: Response<RepositoriesList>) {
        if (response.isSuccessful) {
          appDao.deleteAllRecords()
          response.body()?.items?.forEach {
            insertRecords(it)
          }
        }
      }
    })
  }
}
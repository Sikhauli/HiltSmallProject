package co.za.giantpanda.hilt_mvvm_binding_etc.network

import co.za.giantpanda.hilt_mvvm_binding_etc.db.RepositoriesList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

  @GET("repositories")
  fun getDataFromApi(@Query("q") query: String) : Call<RepositoriesList>

}
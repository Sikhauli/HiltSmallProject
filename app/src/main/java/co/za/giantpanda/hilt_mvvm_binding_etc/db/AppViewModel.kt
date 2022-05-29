package co.za.giantpanda.hilt_mvvm_binding_etc.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import co.za.giantpanda.hilt_mvvm_binding_etc.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel() {


  fun getAllRepositoryList() : LiveData<List<RepositoriesData>>{
    return repository.getAllRecords()
  }

  fun makeApiCall(){
    repository.makeApiCall("ny")
  }

}
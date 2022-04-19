package com.example.myapplication2project.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2project.model.ShowDetailsResponse
import com.example.myapplication2project.model.mostpopulartvs
import com.example.myapplication2project.model.tvshow
import com.example.myapplication2project.service.Episodeservice
import com.example.myapplication2project.views.tvshowlist
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class episodateviewmodel() : ViewModel() {
    var service = Episodeservice.getInstance()

    private val _tvshowlist : MutableLiveData<List<tvshow>> = MutableLiveData()
    private val _error : MutableLiveData<String> = MutableLiveData()
    private val _selected:MutableLiveData<tvshow> = MutableLiveData()
    private val _tvshow:MutableLiveData<tvshow> = MutableLiveData()


    val tvshowlist : LiveData<List<tvshow>> = _tvshowlist
    val error : LiveData<String> = _error;
    val selected : LiveData<tvshow> = _selected;
    val tvShowDetail: LiveData<tvshow> = _tvshow;


    fun loadTvShows(){

        CoroutineScope(Dispatchers.IO).launch {
            service.getpopular().enqueue(object : Callback<mostpopulartvs>{
                override fun onResponse(
                    call: Call<mostpopulartvs>,
                    response: Response<mostpopulartvs>
                ) {
                    _tvshowlist.postValue(response.body()!!.tvshows)
                }

                override fun onFailure(call: Call<mostpopulartvs>, t: Throwable) {
                    _error.postValue(t.message)
                }


            })
        }
    }


    fun setSelectedItem(tvshow: tvshow) {
     _selected.value =tvshow
    }

    fun loadDetail(value: tvshow?) {

        CoroutineScope(Dispatchers.IO).launch {
            service.getShowDetails(selected.value!!.id).enqueue(object: Callback<ShowDetailsResponse>{
                override fun onResponse(
                    call: Call<ShowDetailsResponse>,
                    response: Response<ShowDetailsResponse>
                ) {
                    _tvshow.postValue(response.body()!!.tvshow)
                }

                override fun onFailure(call: Call<ShowDetailsResponse>, t: Throwable) {
                    _error.postValue(t.message)
                }

            })
        }

    }
}
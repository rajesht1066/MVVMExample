package com.example.mvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.network.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.mvvmexample.network.data.Result
import kotlinx.coroutines.Dispatchers

class CustomViewModel : ViewModel(){
    private val resultData = MutableLiveData<List<Result>>()
    val data : LiveData<List<Result>>
        get() = resultData
    init {
        getDataFromApi()
    }
    fun getDataFromApi(){
        GlobalScope.launch(Dispatchers.IO) {
            val result = RetrofitHelper.api.getQuotes()
            Log.d("check",result?.body()?.results.toString())
            //Since it is in Io thread we post the value
            resultData.postValue(result?.body()?.results)
            //If it is in Main thread
            //resultData.value = result?.body()?.results
        }
    }
}
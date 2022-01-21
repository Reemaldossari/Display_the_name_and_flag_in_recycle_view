package com.reemsd.display_the_name_and_flag_in_recycle_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reemsd.display_the_name_and_flag_in_recycle_view.network.CountryApi
import kotlinx.coroutines.launch

class FlagViewModel : ViewModel() {
 private var _countryPic = MutableLiveData<List<Country>>()
 val countryPic : LiveData<List<Country>> = _countryPic



 // it will show msg when reqset Success or Failure
 private var _country = MutableLiveData<String>()
 val country :LiveData<String> = _country



 init {
  getcountryPic()

 }

 fun getcountryPic (){
  viewModelScope.launch {
   try {
    _countryPic.value = CountryApi.retrofitSerivce.getPhoto().data
   }catch(e : Exception) {
     _country.value = "Failure :${e.message}"
   }
   }
  }
 }


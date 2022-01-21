package com.reemsd.display_the_name_and_flag_in_recycle_view

// this is respons class one DataFlag hold list of class country

data class DataFlag (val error :Boolean , val msg :String, val data :List<Country> )
 data class Country (val name :String, val flag :String)


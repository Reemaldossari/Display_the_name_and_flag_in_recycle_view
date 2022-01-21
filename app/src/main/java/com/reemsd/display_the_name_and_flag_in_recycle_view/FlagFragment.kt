package com.reemsd.display_the_name_and_flag_in_recycle_view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.reemsd.display_the_name_and_flag_in_recycle_view.databinding.FragmentFlagBinding

class FlagFragment : Fragment() {
    private val countryViewModel: FlagViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFlagBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.countryViewModel = countryViewModel
        return binding.root
    }


}
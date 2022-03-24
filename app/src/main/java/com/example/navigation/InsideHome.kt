package com.example.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentInsideHomeBinding

class InsideHome : Fragment() {

    private lateinit var binding: FragmentInsideHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = FragmentInsideHomeBinding.inflate(layoutInflater)

        //action_homeFragment_to_insideHome
        val navController = findNavController()
        binding.buttonInsideHomeToProfile.setOnClickListener{
            //navController.navigate(R.id.action_homeFragment_to_insideHome)
            val testArgument = "Click desde el inside home"
            val directions = InsideHomeDirections.actionInsideHomeToProfileFragment(testArgument)
            //NavHostFragment.findNavController(this).navigate(directions)
            navController.navigate(directions)

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButton()
    }

    private fun setupButton(){
        binding.buttonInsideHomeToProfile.setOnClickListener{sendDataToServer()}
    }

    private fun sendDataToServer(){
        if(validateForm()){
            val dataStr = "Name: ${binding.etName.text.toString()}. " +
                    "ApPat: ${binding.etAPat.text.toString()}. " +
                    "ApMat: ${binding.etAMat.text.toString()}. " +
                    "Nickname: ${binding.etNickname.text.toString()}. " +
                    "Email: ${binding.etEmail.text.toString()}"
            Log.i("data sent", dataStr)
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true
        with(binding){
            if (etName.text.toString().isBlank()){
                isValid = false
                tilName.error = getString(R.string.form_required_field)
            }else{
                tilName.error = null
            }
        }
        return isValid

    }


}

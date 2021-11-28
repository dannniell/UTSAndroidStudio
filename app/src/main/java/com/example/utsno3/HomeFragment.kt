package com.example.utsno3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.utsno3.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val REQUEST_CODE = 1
    lateinit var img: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        lateinit var username: String

        //username pharsing
        username = arguments?.getString("username").toString()
        binding.tvUsernameHome.text = username

        //open galery pharsing data
        //dummy (supaya tdkk force close waktu tidak import foto
        img = Uri.parse("android.resource://com.example.utsno3/drawable/ic_launcher_background")
        binding.ivUploadImg.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)

        }

        binding.btnProfile.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("username", username.toString())
                bundle.putString("nama", binding.tIENama.text.toString())
                bundle.putString("nim", binding.tIENIM.text.toString())
                bundle.putString("img", img.toString())
                findNavController().navigate(R.id.action_homeFragment_to_profileFragment, bundle)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            binding.ivUploadImg.setImageURI(data?.data)
            img = data?.data!!
        }
    }
}
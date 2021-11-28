package com.example.utsno3

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.utsno3.databinding.FragmentHomeBinding
import com.example.utsno3.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //username pharsing
        val username: String = arguments?.getString("username").toString()
        binding.tvUsername.text = username

        //foto pharsing
        val img: Uri = Uri.parse(arguments?.getString("img").toString())
        binding.imageView.setImageURI(img)

        //nama pharsing
        val name: String = arguments?.getString("nama").toString()
        binding.tvName.text = name

        //nim pharsing
        val nim: String = arguments?.getString("nim").toString()
        binding.tvNim.text = nim
    }
}
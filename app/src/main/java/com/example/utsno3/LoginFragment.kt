package com.example.utsno3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.utsno3.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if(!binding.tIEUsername.text.toString().equals("admin") || !binding.tIEPassword.text.toString().equals("admin")){
                Toast.makeText(requireContext(), "admin, admin", Toast.LENGTH_LONG).show()
            }else{
                val bundle = Bundle()
                bundle.putString("username", binding.tIEUsername.text.toString())
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            }
        }
    }
}
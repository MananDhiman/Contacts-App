package manandhiman.contacts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import manandhiman.contacts.databinding.FragmentNewContactBinding

class NewContactFragment : Fragment() {

    private lateinit var binding: FragmentNewContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewContactBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
}
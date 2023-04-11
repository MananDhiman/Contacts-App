package manandhiman.contacts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import manandhiman.contacts.R
import manandhiman.contacts.databinding.FragmentAllContactsBinding

class AllContactsFragment : Fragment() {
    private lateinit var binding: FragmentAllContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllContactsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}
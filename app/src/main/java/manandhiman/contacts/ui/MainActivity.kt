package manandhiman.contacts.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import manandhiman.contacts.R
import manandhiman.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newContactFragment = NewContactFragment()
        val allContactsFragment = AllContactsFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, newContactFragment)
            commit()
        }

        binding.mainButtonNew.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, newContactFragment)
                commit()
            }
        }

        binding.mainButtonAll.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, allContactsFragment)
                commit()
            }
        }


    }
}
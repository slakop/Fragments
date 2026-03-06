package otus.gpb.homework.fragments

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import otus.gpb.homework.fragments.databinding.ActivityABinding
import otus.gpb.homework.fragments.databinding.ActivityMainBinding
import otus.gpb.homework.fragments.fragments.FragmentA

class ActivityA : AppCompatActivity() {
    private lateinit var binding: ActivityABinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityABinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerA, FragmentA(), "FragmentA")
                .addToBackStack(null)
                .commit()
        }
    }
}
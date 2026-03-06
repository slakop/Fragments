package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import otus.gpb.homework.fragments.databinding.ActivityBBinding
import otus.gpb.homework.fragments.fragments.FragmentBA
import otus.gpb.homework.fragments.fragments.FragmentBB

class ActivityB : AppCompatActivity() {

    private lateinit var binding: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerBA, FragmentBA())
            .replace(R.id.fragmentContainerBB, FragmentBB())
            .commit()

        switchFragments()
    }

    private fun switchFragments() {

        val currentOrientation = resources.configuration.orientation
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            with(binding) {
                fragmentContainerBA.isVisible = true
                fragmentContainerBB.isVisible = false
            }

        } else {
            with(binding) {
                fragmentContainerBA.isVisible = true
                fragmentContainerBB.isVisible = true
            }
        }
    }
}
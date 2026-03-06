package otus.gpb.homework.fragments.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentABinding
import otus.gpb.homework.fragments.databinding.FragmentBaBinding

private const val KEY = "color"
private const val REQUEST_KEY = "colorBundle"
class FragmentBA : Fragment() {

    private lateinit var binding: FragmentBaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(REQUEST_KEY, this) { _, bundle ->
            val color = bundle.getInt(KEY)
            this.view?.setBackgroundColor(color)
        }

        with(binding.openFragmentBB) {

            setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerBA, FragmentBB())
                    .commit()
            }
            val currentOrientation = resources.configuration.orientation
            isVisible = currentOrientation == Configuration.ORIENTATION_PORTRAIT
        }
    }
}
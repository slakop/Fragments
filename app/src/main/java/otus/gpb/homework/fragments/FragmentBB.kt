package otus.gpb.homework.fragments.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentBbBinding

private const val KEY = "color"
private const val REQUEST_KEY = "colorBundle"
class FragmentBB : Fragment(R.layout.fragment_bb) {

    private lateinit var binding: FragmentBbBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBbBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendColor.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(KEY, ColorGenerator.generateColor())

            parentFragmentManager.setFragmentResult(REQUEST_KEY, bundle)

            val currentOrientation = resources.configuration.orientation
            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerBA, FragmentBA())
                    .commit()
            }
        }
    }
}
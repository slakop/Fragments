package otus.gpb.homework.fragments.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R

private const val KEY = "color"
private const val REQUEST_KEY = "colorBundle"
class FragmentBB : Fragment(R.layout.fragment_bb) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.sendColor).setOnClickListener {

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
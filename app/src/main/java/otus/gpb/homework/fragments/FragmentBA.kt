package otus.gpb.homework.fragments.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R

private const val KEY = "color"
private const val REQUEST_KEY = "colorBundle"
class FragmentBA : Fragment(R.layout.fragment_ba) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(REQUEST_KEY, this) { _, bundle ->
            val color = bundle.getInt(KEY)
            this.view?.setBackgroundColor(color)
        }

        with(view.findViewById<Button>(R.id.openFragmentBB)) {

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
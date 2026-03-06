package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.R
private const val KEY = "color"
class FragmentAB : Fragment(R.layout.fragment_ab) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt(KEY)

        if (color != null) {
            this.view?.setBackgroundColor(color)
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.popBackStack("fragmentAA", 1)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}
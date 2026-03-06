package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.FragmentAaBinding


private const val KEY = "color"
class FragmentAA : Fragment() {

    private lateinit var binding: FragmentAaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = arguments?.getInt(KEY)
        if (color != null) {
            this.view?.setBackgroundColor(color)
        }

        val bundle = Bundle()
        bundle.putInt(KEY, ColorGenerator.generateColor())
        val fragmentAB = FragmentAB()
        fragmentAB.arguments = bundle

        binding.openFragmentAB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerAB, fragmentAB)
                .addToBackStack("fragmentAA")
                .commit()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}
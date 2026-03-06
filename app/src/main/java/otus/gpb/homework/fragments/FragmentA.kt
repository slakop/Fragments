package otus.gpb.homework.fragments.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.ColorGenerator
import otus.gpb.homework.fragments.R
import otus.gpb.homework.fragments.databinding.ActivityMainBinding
import otus.gpb.homework.fragments.databinding.FragmentABinding

private const val KEY = "color"
class FragmentA : Fragment( ) {

    private lateinit var binding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater, container, false)
        binding.openFragmentAA.isEnabled = true
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = Bundle()
        bundle.putInt(KEY, ColorGenerator.generateColor())
        val fragmentAA = FragmentAA()
        fragmentAA.arguments = bundle

        binding.openFragmentAA.setOnClickListener {
            childFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerAA, fragmentAA)
                .addToBackStack("fragmentA")
                .commit()
            binding.openFragmentAA.isEnabled = false
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
               activity?.finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}
package com.example.adv160420103week2_master

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.adv160420103week2_master.databinding.FragmentScoreBinding
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [FinalScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FinalScoreFragment : Fragment() {
    private lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val score = FinalScoreFragmentArgs.fromBundle(requireArguments()).score
        binding.lblTotalScore.text = score.toString()
        binding.btnBackToMain.setOnClickListener {
            findNavController().navigate(R.id.actionFinalFragment)
        }
    }
}


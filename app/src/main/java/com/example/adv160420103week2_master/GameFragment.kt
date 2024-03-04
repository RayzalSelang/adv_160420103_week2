package com.example.adv160420103week2_master

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.adv160420103week2_master.FinalScoreFragmentDirections.Companion.actionFinalFragment
import com.example.adv160420103week2_master.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var playerName: String = ""
    private var score: Int = 0
    private var num1: Int = 0
    private var num2: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
        setupGame()
        binding.btnSubmit.setOnClickListener {
            val answer = binding.txtAnswer.text.toString().toIntOrNull()
            if (answer != null && answer == (num1 + num2)) {
                score += 100 // Add 100 points for a correct answer
                setupGame()
            } else {
                navigateToFinalScoreFragment()
            }
        }
    }

    private fun setupGame() {
        num1 = (1..50).random()
        num2 = (1..50).random()
        binding.txtPlayerName.text = playerName
        binding.ranNum1.text = num1.toString()
        binding.ranNum2.text = num2.toString()
        binding.txtAnswer.text = null
    }

    private fun navigateToFinalScoreFragment() {
        val action = GameFragmentDirections.actionGameFragmentToFinalScoreFragment(score)
        findNavController().navigate(action)
    }
}

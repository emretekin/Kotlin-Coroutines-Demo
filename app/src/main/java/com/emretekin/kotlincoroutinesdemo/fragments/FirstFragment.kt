package com.emretekin.kotlincoroutinesdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.emretekin.kotlincoroutinesdemo.R
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.*


class FirstFragment : Fragment() {

    private val scope = CoroutineScope(context = Dispatchers.IO + CoroutineName("myScope"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val btnGoSecondFrag = view.findViewById<MaterialButton>(R.id.btnGoSecondFrag)
        val startGlobalScope = view.findViewById<Button>(R.id.startGlobalScope)
        val startLifecycleScope = view.findViewById<Button>(R.id.startLifecycleScope)

        btnGoSecondFrag.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        startGlobalScope.setOnClickListener {
            globalScopeProblem()
        }

        startLifecycleScope.setOnClickListener {
            lifecyleScopeCorrection()
        }

        return view
    }

    private fun globalScopeProblem() {
        GlobalScope.launch {
            while (true) {
                delay(1000L)
                Log.d("Coroutine", "Running...")
            }
        }
    }


    private fun lifecyleScopeCorrection() {
        lifecycleScope.launch {
            while (true) {
                delay(1000L)
                Log.d("Coroutine", "Running...")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Coroutine", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Coroutine", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Coroutine", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Coroutine", "onDestroy")
    }
}
package com.emretekin.kotlincoroutinesdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.emretekin.kotlincoroutinesdemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        withContextSample()

        return view
    }

    private fun withContextSample() {
        lifecycleScope.launch(Dispatchers.IO) {
            Log.d("Coroutine", this.coroutineContext.toString())
            // can launch network work and recieved result here

            // then u can just switch context to Dispatchers main to update the ui.
            withContext(Dispatchers.Main) {
                Log.d("Coroutine", this.coroutineContext.toString())
                // UI work
            }

        }
    }
}
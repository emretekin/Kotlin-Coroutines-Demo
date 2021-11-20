package com.emretekin.kotlincoroutinesdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emretekin.kotlincoroutinesdemo.R
import kotlinx.coroutines.*

class ThirdFragment : Fragment() {

    private val scope = CoroutineScope(CoroutineName("myScope"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        val mainJob = scope.launch {
            val job =  launch {
                while (isActive) {
                    yield() //This func suspended fun as well, this func will make our coroutine cancelable
                    Log.d("Coroutine", "Job Running...")
                }
            }

            val job2 = launch {
                Log.d("Coroutine", "Job 2 Running...")
            }

            delay(1000L)
            Log.d("Coroutine", "Canceling...")
            job.cancelAndJoin()
            Log.d("Coroutine", "Job 1 CANCELED!")

            job2.cancelAndJoin()
        }

        runBlocking {
            delay(2000L)
            Log.d("Coroutine", "Canceling...")
            mainJob.cancelAndJoin()
            Log.d("Coroutine", "Main Job CANCELED!")
        }


        return view
    }


}
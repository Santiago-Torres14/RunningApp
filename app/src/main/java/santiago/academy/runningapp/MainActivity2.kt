package santiago.academy.runningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import santiago.academy.runningapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
    }
}
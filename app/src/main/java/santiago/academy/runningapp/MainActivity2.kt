package santiago.academy.runningapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Dao
import dagger.hilt.android.AndroidEntryPoint
import santiago.academy.runningapp.databinding.ActivityMain2Binding
import santiago.academy.runningapp.db.RunDAO
import javax.inject.Inject

private const val TAG = ".MainActivity"

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    @Inject
    lateinit var runDao: RunDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        Log.d(TAG, "RUNDAO: ${runDao.hashCode()}")
    }
}
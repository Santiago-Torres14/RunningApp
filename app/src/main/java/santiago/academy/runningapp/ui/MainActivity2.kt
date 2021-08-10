package santiago.academy.runningapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import santiago.academy.runningapp.R
import santiago.academy.runningapp.databinding.ActivityMain2Binding
import santiago.academy.runningapp.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT


private const val TAG = ".MainActivity"

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        navigateToTrackingFragmentIfNeeded(intent)

        val navHostFragment = findNavController(R.id.navHostFragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.runFragment, R.id.statisticsFragment, R.id.settingsFragment
            )
        )
        setupActionBarWithNavController(navHostFragment, appBarConfiguration)

        binding.bottomNavigationView.setupWithNavController(navHostFragment)

        navHostFragment.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE
                else -> binding.bottomNavigationView.visibility = View.GONE
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?){
        if(intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
            val navHostFragment = findNavController(R.id.navHostFragment)
            navHostFragment.navigate(R.id.action_global_trackingFragment)
        }
    }

}
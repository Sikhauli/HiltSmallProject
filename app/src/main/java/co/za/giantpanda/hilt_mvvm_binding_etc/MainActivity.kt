package co.za.giantpanda.hilt_mvvm_binding_etc

import android.os.Bundle
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import co.za.giantpanda.hilt_mvvm_binding_etc.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var mainBinding: ActivityMainBinding
  private lateinit var viewFlipper: ViewFlipper

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(null)
    mainBinding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(mainBinding.root)

  }
}



